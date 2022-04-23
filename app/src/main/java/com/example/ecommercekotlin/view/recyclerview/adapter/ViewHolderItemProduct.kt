package com.example.ecommercekotlin.view.recyclerview.adapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ecommercekotlin.R
import com.example.ecommercekotlin.databinding.ItemProductBinding
import com.example.ecommercekotlin.extensions.formatAmountBrazil
import com.example.ecommercekotlin.extensions.loaderImages
import com.example.ecommercekotlin.modal.Products
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class ViewHolderItemProduct(val binding: ItemProductBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(product: Products) {

        val txtName = binding.txtName
        val txtDescripton = binding.txtDescripton
        val txtPrice = binding.txtPrice
        val cardView = binding.layoutmain


        val visibilidade = if (product.imagen != null){
            View.VISIBLE
        }else{
            View.GONE
        }


        binding.imageView.visibility = visibilidade
        binding.imageView.loaderImages(product.imagen)
        val formatAmount: String? = formatAmountBrazil(product.price)

        txtName.text = product.name
        txtDescripton.text = product.description
        txtPrice.text = formatAmount


    }


}