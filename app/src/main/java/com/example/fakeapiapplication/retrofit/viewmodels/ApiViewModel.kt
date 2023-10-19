package com.example.fakeapiapplication.retrofit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fakeapiapplication.retrofit.repository.ProductRepository
import com.example.fakeapiapplication.retrofit.repository.UsersRepository
import com.example.fakeapiapplication.retrofit.response.ProductList
import com.example.fakeapiapplication.retrofit.response.UserList

class ApiViewModel:ViewModel() {

    val ProductRepo=ProductRepository()

    var productloding: MutableLiveData<Boolean> = ProductRepo.productloding

    val UserRepo=UsersRepository()

    var userloading:MutableLiveData<Boolean> = UserRepo.userlodding

    fun getProduct(): LiveData<ProductList> {
        return ProductRepo.GetProduct()
    }

    fun getUsers():LiveData<UserList>{
        return UserRepo.getUser()
    }
}