package com.example.fakeapiapplication.retrofit.adapters

import com.example.fakeapiapplication.retrofit.datamodels.ProductData
import com.example.fakeapiapplication.retrofit.response.ProductList

interface itemclicklistener {
    fun clicklistener(position:Int,data:ProductData)
}