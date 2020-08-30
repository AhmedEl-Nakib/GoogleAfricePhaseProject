package com.example.googleafricephaseproject.ui.learningLeaders

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.googleafricephaseproject.pojo.response.LearningLeadersResponseItem
import com.example.googleafricephaseproject.networking.HomeRequests
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class LearningLeadersViewModel(private val serviceGeneral: HomeRequests) : ViewModel(){

    var learningLeadersList: MutableLiveData<List<LearningLeadersResponseItem>> = MutableLiveData()
    var loader = MutableLiveData<Boolean>(false)


    fun getLearningLeadersList(context: Context) {
        try {
            loader.value = true
            CoroutineScope(Dispatchers.IO).async {
                runCatching {
                    serviceGeneral.getLearningLeaders()
                }.onSuccess {
                    withContext(Dispatchers.Main) {
                        try {
                            if (it.isSuccessful) {

                                learningLeadersList.value = it.body()
                                loader.value = false
                                Log.i("Response", it.body()!!.toString())
                            } else {
                                Toast.makeText(context, "Error " + it.message(), Toast.LENGTH_SHORT).show()
                                loader.value = false
                            }
                        } catch (e: Exception) {
                            Toast.makeText(context, e.message.toString(), Toast.LENGTH_SHORT).show()
                            loader.value = false

                        }
                    }
                }.onFailure {
                    Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
                    loader.value = false

                }
            }

        }catch (e:Exception){
            Toast.makeText(context, e.message.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}