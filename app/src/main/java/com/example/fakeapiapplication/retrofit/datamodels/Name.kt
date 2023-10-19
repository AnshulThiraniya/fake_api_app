package com.example.fakeapiapplication.retrofit.datamodels

import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("firstname")
    var fname:String,

    @SerializedName("lastname")
    var lname:String
)
