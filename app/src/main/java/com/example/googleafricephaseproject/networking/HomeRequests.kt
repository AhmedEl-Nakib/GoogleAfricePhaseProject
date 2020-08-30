package com.example.googleafricephaseproject.networking

import com.example.googleafricephaseproject.pojo.response.LearningLeadersResponse
import com.example.googleafricephaseproject.pojo.response.SkillIQLeadersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers


interface HomeRequests {
    

    @Headers("Content-Type: application/json; charset=utf-8")
    @GET("/api/hours")
    suspend fun getLearningLeaders(): Response<LearningLeadersResponse>

    @GET("/api/skilliq")
    suspend fun getSkillsIQLeaders(): Response<SkillIQLeadersResponse>

}