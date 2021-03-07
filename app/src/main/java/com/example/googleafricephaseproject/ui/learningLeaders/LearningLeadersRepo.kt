package com.example.googleafricephaseproject.ui.learningLeaders

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.googleafricephaseproject.networking.HomeRequests
import com.example.googleafricephaseproject.pojo.response.LearningLeadersResponse
import com.example.googleafricephaseproject.utils.NetworkFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class LearningLeadersRepo(private val api: HomeRequests , context:Context) : NetworkFactory(context){
//    suspend fun getLearningLeaders(): Flow<retrofit2.Response<LearningLeadersResponse>> {
//        return flow {
//            emit(api.getLearningLeaders())
//        }.flowOn(Dispatchers.IO)
////        return api.getLearningLeaders()
////            .map { fooFromApi ->
////                FooUI.fromResponse(fooFromApi)}
////            .asFlow()
////            .flowOn(Dispatchers.IO)
//    }

//    fun getLearningLeaders(): Flow<Result<LearningLeadersResponse>> = flow {
//        emit(Result.success(api.getLearningLeaders()))
//    }.catch { e ->
//        emit(Result.failure(e))
//    }

    suspend fun getLearningLeaders(): Flow<LearningLeadersResponse?> {
//        Log.i("Repooooo1",api.getLearningLeaders().toString())

        return flow {
            if(isNetworkConnected()) {
                emit(api.getLearningLeaders().body())
            }else
                emit(null)
        }.flowOn(Dispatchers.IO)
    }
}