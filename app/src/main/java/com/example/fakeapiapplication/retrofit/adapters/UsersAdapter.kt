package com.example.fakeapiapplication.retrofit.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fakeapiapplication.databinding.UserListItemBinding
import com.example.fakeapiapplication.retrofit.response.UserList
import com.squareup.picasso.Picasso

class UsersAdapter(val context: Context, val list: UserList):
    RecyclerView.Adapter<UsersAdapter.MyviewHolder>() {

    inner class MyviewHolder(var binding: UserListItemBinding): RecyclerView.ViewHolder(binding.root){

    }
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        var view= UserListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyviewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        var product=list[position]
        holder.binding.name.text= "Name:- ${product.name.fname} ${product.name.lname}"
        holder.binding.usernameId.text="Username:- ${product.username}"
        holder.binding.email.text="Email:-  ${product.email}"
        holder.binding.phone.text="Phone:-  ${product.number}"
        holder.binding.address.text="Address:-  ${product.address.city} ${product.address.street} " +
                        "${product.address.homeno} ${product.address.zipcode} ${product.address.geolocation.lat} ${product.address.geolocation.long}"

    }
}