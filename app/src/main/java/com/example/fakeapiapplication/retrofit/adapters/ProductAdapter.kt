package com.example.fakeapiapplication.retrofit.adapters


import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fakeapiapplication.databinding.ProductListItemBinding
import com.example.fakeapiapplication.retrofit.response.ProductList
import com.squareup.picasso.Picasso

class ProductAdapter (val context: Context, val list: ProductList,var itemclicklistener: itemclicklistener):
    RecyclerView.Adapter<ProductAdapter.MyviewHolder>() {

    inner class MyviewHolder(var binding: ProductListItemBinding): RecyclerView.ViewHolder(binding.root){

    }
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        var view= ProductListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyviewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        var product=list[position]
        holder.binding.productTitle.text=product.title
        holder.binding.productCatogery.text=product.category
        Picasso.get().load(product.image).into(holder.binding.productImg)

       holder.binding.recyclerId.setOnClickListener {
           itemclicklistener.clicklistener(position,product)

       }
    }
}