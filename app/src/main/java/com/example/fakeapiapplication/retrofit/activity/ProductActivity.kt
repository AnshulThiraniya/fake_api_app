package com.example.fakeapiapplication.retrofit.activity


import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fakeapiapplication.R
import com.example.fakeapiapplication.databinding.ActivityProductBinding
import com.example.fakeapiapplication.retrofit.adapters.ProductAdapter
import com.example.fakeapiapplication.retrofit.adapters.itemclicklistener
import com.example.fakeapiapplication.retrofit.datamodels.ProductData
import com.example.fakeapiapplication.retrofit.viewmodels.ApiViewModel
import com.google.gson.Gson

class ProductActivity : AppCompatActivity(), itemclicklistener {

 lateinit var binding:ActivityProductBinding
 lateinit var viewmodel:ApiViewModel
 lateinit var myAdapter:ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this, R.layout.activity_product)
        setTitle("Products")

         viewmodel=ViewModelProvider(this)[ApiViewModel::class.java]

        var progressDialog= ProgressDialog(this)
        progressDialog.setMessage("loading please wait...")
        progressDialog.setCancelable(false)

        viewmodel.productloding.observe(this, Observer {
            if(it){
                progressDialog.show()
            }
            else{
                progressDialog.dismiss()
            }
        })

        viewmodel.getProduct().observe(this, Observer {
            myAdapter=ProductAdapter(this,it, this)
            binding.rvProductItem.layoutManager=LinearLayoutManager(this)
            binding.rvProductItem.adapter=myAdapter
            myAdapter.notifyDataSetChanged()

        })

    }

    @SuppressLint("SuspiciousIndentation")
    override fun clicklistener(position: Int, data: ProductData) {
      val intent=Intent(this,DetailsActivity::class.java)
        intent.putExtra("mydata",Gson().toJson(data))
        startActivity(intent)
    }

}