package com.my.postapitask

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.my.postapitask.model.LoginRequestData
import com.my.postapitask.model.LoginResponse
import com.my.postapitask.networkCalls.ApiInterface
import com.my.postapitask.networkCalls.Repository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainVM : ViewModel(){

    var responseData : LoginResponse? = null
    var userName : String ="kminchelle"
    var password : String = "0lelplR"

    @SuppressLint("SuspiciousIndentation")
    fun login() = viewModelScope.launch{
        val apiInterface = Repository.getInstance().create(ApiInterface::class.java)
        val call: Call<LoginResponse> = apiInterface.login(LoginRequestData(
            username = userName.trim(),
            password = password.trim()
        )
        )
        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                // Handle the response here
                if (response.isSuccessful) {
                    val loginResponse: LoginResponse? = response.body()
                    if (loginResponse!=null){
                        val apiResponse = Gson().toJson(loginResponse, LoginResponse::class.java)

                        Log.e("TAG","Api Response is: $apiResponse")
                        responseData= loginResponse
                        Log.e("TAG","loginResponse is: $loginResponse")

                    }
                    // Process the successful response
                } else {
                    // Handle error response
                    Log.e("TAG","Api Response is not successful ${response.message()}")

                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e("TAG","Api Fail")
            }
        })



    }
}