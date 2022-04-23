package com.example.ecommercekotlin.extensions

import android.widget.ImageView
import coil.load
import com.example.ecommercekotlin.R
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

fun ImageView.loaderImages(url: String? = null) {
    load(url) {
        fallback(com.example.ecommercekotlin.R.drawable.imagem_padrao)
        error(com.example.ecommercekotlin.R.drawable.erro)
        placeholder(com.example.ecommercekotlin.R.drawable.placeholder)

    }

}