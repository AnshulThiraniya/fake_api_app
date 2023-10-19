package com.example.fakeapiapplication.retrofit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.fakeapiapplication.R
import com.example.fakeapiapplication.databinding.ActivityDetailsBinding
import com.example.fakeapiapplication.databinding.ActivityMainBinding
import com.example.fakeapiapplication.retrofit.datamodels.ProductData
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_details)

        var  data=intent
        var stdata=data.getStringExtra("mydata")
        var tempdata=Gson().fromJson(stdata,ProductData::class.java)

        binding.productTitle.text="Title:- ${tempdata.title}"
        binding.productCategory.text="Category:-  ${tempdata.category}"
        binding.productRs.text="Price:-  ${tempdata.price.toString()}"
        binding.productDiscription.text="Description:-  ${tempdata.description}"

        binding.productRating.rating=tempdata.rating.rate.toFloat()
        binding.ratingCount.text=tempdata.rating.count.toString()
        Picasso.get().load(tempdata.image).into(binding.datailistImgId)

    }
}