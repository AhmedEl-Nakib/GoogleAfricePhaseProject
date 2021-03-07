package com.example.googleafricephaseproject.ui.projectSubmission

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.googleafricephaseproject.R
import com.example.googleafricephaseproject.networking.ProjectRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class ProjectSubmissionViewModel(private val serviceGeneral: ProjectRequest): ViewModel() {

    var fName = MutableLiveData<String>("")
    var lName = MutableLiveData<String>("")
    var email = MutableLiveData<String>("")
    var projectLink = MutableLiveData<String>("")

    var loader = MutableLiveData<Boolean>(false)

    private fun submit(v: View)
    {
        try {
            loader.value = true
            CoroutineScope(Dispatchers.IO).async {
                runCatching { serviceGeneral.submitProject(fName.value!!,lName.value!!,email.value!!,projectLink.value!!) }
                    .onSuccess {
                        withContext(Dispatchers.Main) {
                            try {
                                if (it.isSuccessful && it.code() == 200) {
                                    loader.value = false
                                    showResultAlert(v, R.layout.success_submission)
                                } else {
                                    loader.value = false
                                    showResultAlert(v, R.layout.invalid_submission)

                                }
                            } catch (e: Exception) {
                                Toast.makeText(
                                    v.rootView.context,
                                    e.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                                loader.value = false

                            }
                        }
                    }.onFailure {
                        Toast.makeText(
                            v.rootView.context,
                            it.message.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                        loader.value = false

                    }
            }
        }catch (e:Exception){
            Toast.makeText(v.rootView.context, e.message.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    fun showAlert(v: View)
    {
        val alert: Dialog? = Dialog(v.rootView.context)
        alert?.setContentView(R.layout.ask_user_dialog)
        alert?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alert?.findViewById<Button>(R.id.btnYesId)?.setOnClickListener {
            submit(v)
            alert.dismiss()
        }
        alert?.findViewById<ImageView>(R.id.btnCloseId)?.setOnClickListener {
            alert.dismiss()
        }

        alert?.show()
    }

    private fun showResultAlert(v:View, resource:Int)
    {
        val alert: Dialog? = Dialog(v.rootView.context)
        alert?.setContentView(resource)
        alert?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alert?.show()
    }

    override fun onCleared() {
        super.onCleared()
    }

}