package com.example.googleafricephaseproject.ui.learningLeaders

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.googleafricephaseproject.pojo.response.LearningLeadersResponseItem
import com.example.googleafricephaseproject.networking.HomeRequests
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect

class LearningLeadersViewModel(private val serviceGeneral: LearningLeadersRepo) : ViewModel(){

    var learningLeadersList = MutableLiveData<List<LearningLeadersResponseItem>>()
    var loader = MutableLiveData<Boolean>(false)


//    fun getLearningLeadersList(context: Context) {
//        try {
//            loader.value = true
//            CoroutineScope(Dispatchers.IO).async {
//                runCatching {
//                    serviceGeneral.getLearningLeaders()
//                }.onSuccess {
//                    withContext(Dispatchers.Main) {
//                        try {
//                            if (it.isSuccessful) {
//
//                                learningLeadersList.value = it.body()
//                                loader.value = false
//                                Log.i("Response", it.body()!!.toString())
//                            } else {
//                                Toast.makeText(context, "Error " + it.message(), Toast.LENGTH_SHORT).show()
//                                loader.value = false
//                            }
//                        } catch (e: Exception) {
//                            Toast.makeText(context, e.message.toString(), Toast.LENGTH_SHORT).show()
//                            loader.value = false
//
//                        }
//                    }
//                }.onFailure {
//                    Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
//                    loader.value = false
//
//                }
//            }
//
//        }catch (e:Exception){
//            Toast.makeText(context, e.message.toString(), Toast.LENGTH_SHORT).show()
//        }
//    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }

    fun getLearningLeadersList(context: Context) {
        try {
            loader.value = true
            viewModelScope.async {
                Log.i("VM1","true")
//                learningLeadersList.value = serviceGeneral.getLearn().collect ()
                serviceGeneral.getLearningLeaders().catch {
                    Toast.makeText(context,it.message,Toast.LENGTH_SHORT).show()
                }.collect {
                    Log.i("VM2", it.toString())
                    learningLeadersList.value = it
                    Log.i("VM3", it.toString())

                    loader.value = false
                }
            }

        }catch (e:Exception){
            Toast.makeText(context, e.message.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}