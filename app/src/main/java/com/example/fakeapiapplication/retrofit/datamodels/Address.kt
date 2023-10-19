package com.example.fakeapiapplication.retrofit.datamodels

import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("city")
    var city:String,

    @SerializedName("street")
    var street:String,

    @SerializedName("number")
    var homeno:Int,

    @SerializedName("zipcode")
    var zipcode:String,

    @SerializedName("geolocation")
    var geolocation:Geolocation

)
