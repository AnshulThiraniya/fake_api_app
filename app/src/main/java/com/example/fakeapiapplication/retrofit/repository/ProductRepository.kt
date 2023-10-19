package com.example.fakeapiapplication.retrofit.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.fakeapiapplication.retrofit.response.ProductList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductRepository {
    val liveProducts: MutableLiveData<ProductList> = MutableLiveData<ProductList>()
    var productloding: MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply {
        value=true
    }

    fun GetProduct(): MutableLiveData<ProductList> {
        val call=com.example.fakeapiapplication.retrofit.network.Retrofit.Apicall.getProduct()
        call.enqueue(object : Callback<ProductList> {
            override fun onResponse(call: Call<ProductList>, response: Response<ProductList>) {
                if(response.isSuccessful){
                    productloding.value=false
                    liveProducts.value=response.body()
                }
            }

            override fun onFailure(call: Call<ProductList>, t: Throwable) {
                productloding.value=false
            }

        })
        return liveProducts
    }
}