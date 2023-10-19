package com.example.fakeapiapplication.retrofit.datamodels

import com.google.gson.annotations.SerializedName

data class ProductData(
    @SerializedName("title")
    var title:String,

    @SerializedName("price")
    var price:Double,

    @SerializedName("category")
    var category:String,

    @SerializedName("image")
    var image:String,

    @SerializedName("description")
    var description:String,

    @SerializedName("rating")
    var rating:RatingData
)
