//package com.example.googleafricephaseproject.ui.learningLeaders
//
//import android.content.Context
//import androidx.work.CoroutineWorker
//import androidx.work.Worker
//import androidx.work.WorkerParameters
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.withContext
//
//class LearningLeadersWorker (private val context: Context, private val workerParameters: WorkerParameters)
//    : CoroutineWorker(context,workerParameters) {
//    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
//
//        try {
//            // Do something
//            Result.success()
//        } catch (error: Throwable) {
//            Result.failure()
//        }
//    }
//
//    private fun fetchData() {
//
//    }
//}