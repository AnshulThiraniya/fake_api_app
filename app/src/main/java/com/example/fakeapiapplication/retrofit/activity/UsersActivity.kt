package com.example.fakeapiapplication.retrofit.activity

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fakeapiapplication.R
import com.example.fakeapiapplication.databinding.ActivityProductBinding
import com.example.fakeapiapplication.databinding.ActivityUsersBinding
import com.example.fakeapiapplication.retrofit.adapters.ProductAdapter
import com.example.fakeapiapplication.retrofit.adapters.UsersAdapter
import com.example.fakeapiapplication.retrofit.viewmodels.ApiViewModel

class UsersActivity : AppCompatActivity() {

    lateinit var binding: ActivityUsersBinding
    lateinit var viewmodel: ApiViewModel
    lateinit var myAdapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_users)
        setTitle("Users")

        viewmodel= ViewModelProvider(this)[ApiViewModel::class.java]

        var progressDialog= ProgressDialog(this)
        progressDialog.setMessage("loading please wait...")
        progressDialog.setCancelable(false)

        viewmodel.userloading.observe(this, Observer {
            if(it){
                progressDialog.show()
            }
            else{
                progressDialog.dismiss()
            }
        })

        viewmodel.getUsers().observe(this, Observer {
            myAdapter=UsersAdapter(this,it)
            binding.rvUsersItem.layoutManager= LinearLayoutManager(this)
            binding.rvUsersItem.adapter=myAdapter
            myAdapter.notifyDataSetChanged()

        })

    }

}