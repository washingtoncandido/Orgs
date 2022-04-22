package com.example.ecommercekotlin.view.recyclerview.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercekotlin.R
import com.example.ecommercekotlin.modal.Products

class ViewHolderItemProduct(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(product: Products) {


        val txtName = itemView.findViewById<TextView>(R.id.txt_name)
        val txtPrice = itemView.findViewById<TextView>(R.id.txt_price)
        val txtDescription = itemView.findViewById<TextView>(R.id.txt_descripton)

        txtName.text = product.name
        txtDescription.text = product.description
        txtPrice.text = product.price.toPlainString()


    }
}