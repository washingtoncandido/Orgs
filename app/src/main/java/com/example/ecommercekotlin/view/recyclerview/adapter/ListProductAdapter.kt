package com.example.ecommercekotlin.view.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercekotlin.R
import com.example.ecommercekotlin.modal.Products



class ListProductAdapter(val context: Context, private val products: List<Products>) :
    RecyclerView.Adapter<ViewHolderItemProduct>() {

    //ele vai ser o responsaval para criar cada uma das vieows para fazer o processo de bind
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItemProduct {
        val inflate =
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolderItemProduct(view = inflate)
    }


    // vai informa qual o item que está naquele momento,você consegue modifica cada item de acordo com a position
    override fun onBindViewHolder(holder: ViewHolderItemProduct, position: Int) {
        val product = products[position]

        holder.bind(product)
    }

    //determina o valor dos item
    override fun getItemCount(): Int {
        return products.size
    }


}
