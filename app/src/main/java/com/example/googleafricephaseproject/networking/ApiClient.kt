package com.example.googleafricephaseproject.networking

import android.content.Context
import com.example.googleafricephaseproject.ui.learningLeaders.LearningLeadersRepo
import com.example.googleafricephaseproject.ui.learningLeaders.LearningLeadersViewModel
import com.example.googleafricephaseproject.ui.projectSubmission.ProjectSubmissionViewModel
import com.example.googleafricephaseproject.ui.skillIQ.SkillIQLeadersViewModel
import com.example.googleafricephaseproject.utils.NetworkFactory
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.java.KoinJavaComponent.get

object ApiClient {

    private const val BASE_URL_HOME = "https://gadsapi.herokuapp.com"


    val homeModule = module {
        fun makeRetrofitService(): HomeRequests {
            return Retrofit.Builder()
                .baseUrl(BASE_URL_HOME)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(HomeRequests::class.java)
        }

        single { makeRetrofitService() }
    }

    val homeLearningLeadersModule = module { viewModel { LearningLeadersViewModel(get()) } }
    val homeSkillIQLeadersModule = module { viewModel { SkillIQLeadersViewModel(get()) } }


    private const val BASE_URL_PROJECT = "https://docs.google.com/forms/d/e/"
    val projectModule = module {
        fun makeRetrofitServiceProject(): ProjectRequest {
            return Retrofit.Builder()
                .baseUrl(BASE_URL_PROJECT)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ProjectRequest::class.java)
        }

        single { makeRetrofitServiceProject() }
    }
    val projectSubmissionModule = module { viewModel { ProjectSubmissionViewModel(get()) } }


    private fun provideLearningLeadersRepository(api: HomeRequests,context: Context): LearningLeadersRepo {
        return LearningLeadersRepo(api,context)
    }
    val repositoryModule = module {
        single { provideLearningLeadersRepository(get(),androidApplication()) }
    }

    val networkFactory = module {
        single { NetworkFactory(androidApplication()) }
    }

}