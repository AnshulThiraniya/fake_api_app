package com.example.fakeapiapplication.retrofit.datamodels

import com.google.gson.annotations.SerializedName

data class RatingData(
    @SerializedName("rate")
    var rate:Double,

    @SerializedName("count")
    var count:Int
)
