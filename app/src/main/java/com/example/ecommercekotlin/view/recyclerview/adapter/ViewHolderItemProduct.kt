package com.example.ecommercekotlin.view.recyclerview.adapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercekotlin.databinding.ItemProductBinding
import com.example.ecommercekotlin.extensions.formatValueBrazil
import com.example.ecommercekotlin.extensions.loaderImages
import com.example.ecommercekotlin.modal.Products

class ViewHolderItemProduct(val binding: ItemProductBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(product: Products) {

        val txtName = binding.productItemName
        val txtDescripton = binding.productItemDescripton
        val txtPrice = binding.productItemPrice

        val formatAmount: String = product.price.formatValueBrazil()

        txtName.text = product.name
        txtDescripton.text = product.description
        txtPrice.text = formatAmount
        val visibilidade = if (product.imagen != null) {
            View.VISIBLE
        } else {
            View.GONE
        }
        binding.imageView.visibility = visibilidade
        binding.imageView.loaderImages(product.imagen)


    }


}