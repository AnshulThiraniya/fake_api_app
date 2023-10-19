package com.example.fakeapiapplication.retrofit.datamodels

import com.google.gson.annotations.SerializedName

data class Userdata(
    @SerializedName("name")
    var name:Name,

    @SerializedName("username")
    var username:String,

    @SerializedName("email")
    var email:String,

    @SerializedName("phone")
    var number:String,

    @SerializedName("address")
    var address:Address
)
