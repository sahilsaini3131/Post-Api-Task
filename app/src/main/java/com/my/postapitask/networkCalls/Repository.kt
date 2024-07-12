package com.my.postapitask.networkCalls

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Repository {

        val baseUrl = "https://dummyjson.com/auth/"

        fun getInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                // we need to add converter factory to
                // convert JSON object to Java object
                .build()
        }
    }
