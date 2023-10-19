package com.example.fakeapiapplication.retrofit.network

import com.example.fakeapiapplication.retrofit.methods.ApiMethods
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    private val Retrofitclient: Retrofit.Builder by lazy {
        Retrofit.Builder().baseUrl("https://fakestoreapi.com")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
    }

    val Apicall: ApiMethods by lazy {
        Retrofitclient.build().create(ApiMethods::class.java)
    }
}