package com.example.googleafricephaseproject.ui.skillIQ

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.googleafricephaseproject.pojo.response.SkillIQLeadersResponseItem
import com.example.googleafricephaseproject.networking.HomeRequests
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class SkillIQLeadersViewModel(private val serviceGeneral: HomeRequests) : ViewModel(){

    var skillIQLeadersList: MutableLiveData<List<SkillIQLeadersResponseItem>> = MutableLiveData()
    var loader = MutableLiveData<Boolean>(false)


    fun getSkillIQLeadersList(context: Context) {
        try {
            loader.value = true
            CoroutineScope(Dispatchers.IO).async {
                runCatching { serviceGeneral.getSkillsIQLeaders() }
                    .onSuccess {

                        withContext(Dispatchers.Main) {
                            try {
                                if (it.isSuccessful) {

                                    skillIQLeadersList.value = it.body()
                                    loader.value = false
                                } else {
                                    Toast.makeText(
                                        context,
                                        "Error " + it.message(),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    loader.value = false
                                }
                            } catch (e: Exception) {
                                Toast.makeText(context, e.message.toString(), Toast.LENGTH_SHORT)
                                    .show()
                                loader.value = false

                            }
                        }
                    }.onFailure {
                        Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT)
                            .show()
                        loader.value = false

                    }
            }
        }catch (e:Exception){
            Toast.makeText(context, e.message.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}