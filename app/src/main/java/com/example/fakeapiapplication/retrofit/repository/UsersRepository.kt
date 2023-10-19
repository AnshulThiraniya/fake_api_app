package com.example.fakeapiapplication.retrofit.repository

import androidx.lifecycle.MutableLiveData
import com.example.fakeapiapplication.retrofit.network.Retrofit
import com.example.fakeapiapplication.retrofit.response.UserList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersRepository {
    val userlivedata:MutableLiveData<UserList> = MutableLiveData<UserList>()
    val userlodding:MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply {
        value=true
    }

    fun getUser():MutableLiveData<UserList> {
        val call= Retrofit.Apicall.getUsers()
        call.enqueue(object : Callback<UserList> {
            override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
                if(response.isSuccessful){
                    userlodding.value=false
                    userlivedata.value=response.body()
                }
            }

            override fun onFailure(call: Call<UserList>, t: Throwable) {
                userlodding.value=false
            }

        })
        return userlivedata
    }



}