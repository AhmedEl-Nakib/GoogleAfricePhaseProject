package com.example.googleafricephaseproject.networking

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*


interface ProjectRequest {
    

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    suspend fun submitProject(@Field("entry.1824927963") email:String,
    @Field("entry.1877115667") fName:String,
    @Field("entry.2006916086") lName:String,
    @Field("entry.284483984") linkToProject:String): Response<Void>


}