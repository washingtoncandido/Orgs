package com.example.ecommercekotlin.view.recyclerview.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercekotlin.databinding.ItemProductBinding
import com.example.ecommercekotlin.modal.Products

class ViewHolderItemProduct(val binding: ItemProductBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(product: Products) {

        val txtName = binding.txtName
        val txtPrice = binding.txtDescripton
        val txtDescription = binding.txtPrice

        txtName.text = product.name
        txtDescription.text = product.description
        txtPrice.text = product.price?.toPlainString()


    }
}