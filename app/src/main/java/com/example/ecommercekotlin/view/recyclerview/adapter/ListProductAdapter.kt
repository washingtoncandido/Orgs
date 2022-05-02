package com.example.ecommercekotlin.view.recyclerview.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercekotlin.view.activity.DetailProductActivity
import com.example.ecommercekotlin.R
import com.example.ecommercekotlin.databinding.ItemProductBinding
import com.example.ecommercekotlin.modal.Products
import com.example.ecommercekotlin.view.activity.ListActivity
import okhttp3.internal.notify


class ListProductAdapter(
    val context: Context,
    products: List<Products> = emptyList(),
    val clickProduct: onItemClick
) :
    RecyclerView.Adapter<ViewHolderItemProduct>() {

    private lateinit var binding: ItemProductBinding

    //lista atualizada
    private val dateSet = products.toMutableList()

    //ele vai ser o responsaval para criar cada uma das vieows para fazer o processo de bind
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItemProduct {
        binding = ItemProductBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolderItemProduct(binding)
    }


    // vai informa qual o item que está naquele momento,você consegue modifica cada item de acordo com a position
    override fun onBindViewHolder(holder: ViewHolderItemProduct, position: Int) {
        val product = dateSet[position]
        holder.binding.layoutmain.setOnClickListener {
            clickProduct.clickProduct(product)
        }
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



    interface onItemClick {
        fun clickProduct(product: Products)
    }


}
