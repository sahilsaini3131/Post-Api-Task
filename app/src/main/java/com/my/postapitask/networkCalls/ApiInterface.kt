package com.my.postapitask.networkCalls

import com.my.postapitask.model.LoginRequestData
import com.my.postapitask.model.LoginResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("login")
    fun login(
        @Body loginRequestData: LoginRequestData
    ): Call<LoginResponse>
}