package com.example.fakeapiapplication.retrofit.datamodels

import com.google.gson.annotations.SerializedName

data class Geolocation(
    @SerializedName("lat")
    var lat:String,

    @SerializedName("long")
    var long:String
)
