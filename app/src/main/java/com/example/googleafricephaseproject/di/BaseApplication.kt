package com.example.googleafricephaseproject.di

import android.app.Application
import com.example.googleafricephaseproject.networking.ApiClient.homeLearningLeadersModule
import com.example.googleafricephaseproject.networking.ApiClient.homeModule
import com.example.googleafricephaseproject.networking.ApiClient.homeSkillIQLeadersModule
import com.example.googleafricephaseproject.networking.ApiClient.networkFactory
import com.example.googleafricephaseproject.networking.ApiClient.projectModule
import com.example.googleafricephaseproject.networking.ApiClient.projectSubmissionModule
import com.example.googleafricephaseproject.networking.ApiClient.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidContext(this@BaseApplication)
            modules(listOf(homeModule,
                homeLearningLeadersModule,
                homeSkillIQLeadersModule,
                projectModule,
                projectSubmissionModule,
                repositoryModule,
                networkFactory
            ))
        }
    }
}