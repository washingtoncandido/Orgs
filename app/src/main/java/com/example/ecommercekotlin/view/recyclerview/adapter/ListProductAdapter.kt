package com.example.ecommercekotlin.view.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercekotlin.R
import com.example.ecommercekotlin.databinding.ItemProductBinding
import com.example.ecommercekotlin.modal.Products


class ListProductAdapter(val context: Context, products: List<Products>) :
    RecyclerView.Adapter<ViewHolderItemProduct>() {

    //lista atualizada
    private val dateSet = products.toMutableList()

    //ele vai ser o responsaval para criar cada uma das vieows para fazer o processo de bind
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItemProduct {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolderItemProduct(binding)
    }


    // vai informa qual o item que está naquele momento,você consegue modifica cada item de acordo com a position
    override fun onBindViewHolder(holder: ViewHolderItemProduct, position: Int) {
        val product = dateSet[position]

        holder.bind(product)
    }

    //determina o valor dos item
    override fun getItemCount(): Int {
        return dateSet.size
    }

    //metodo usado para mostra a lista atualizada
    fun attAllProduts(product: List<Products>) {
        this.dateSet.clear()
        this.dateSet.addAll(product)
        notifyDataSetChanged()
    }


}
