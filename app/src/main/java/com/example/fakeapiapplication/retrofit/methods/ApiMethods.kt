package com.example.fakeapiapplication.retrofit.methods

import com.example.fakeapiapplication.retrofit.response.ProductList
import com.example.fakeapiapplication.retrofit.response.UserList
import retrofit2.Call
import retrofit2.http.GET

interface ApiMethods {
    @GET("/products")
    fun getProduct():Call<ProductList>

    @GET("/users")
    fun getUsers():Call<UserList>
}