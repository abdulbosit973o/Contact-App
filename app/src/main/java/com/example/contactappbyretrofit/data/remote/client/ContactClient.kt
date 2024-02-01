package com.example.contactappbyretrofit.data.remote.client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ContactClient {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://47a4-94-158-61-221.ngrok-free.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}