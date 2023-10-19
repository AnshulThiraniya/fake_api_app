package com.example.fakeapiapplication.retrofit.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.fakeapiapplication.R
import com.example.fakeapiapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnProducts.setOnClickListener(this)
        binding.btnUsers.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_products -> {
                val intent = Intent(this, ProductActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_users->{
                 val intent=Intent(this,UsersActivity::class.java)
                startActivity(intent)
            }

        }
    }

}