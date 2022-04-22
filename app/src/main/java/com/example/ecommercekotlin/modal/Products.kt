package com.example.ecommercekotlin.modal

import java.math.BigDecimal

data class Products(
    val name: String,
    val description: String,
    val price: BigDecimal? = null,
    val imagen: String? = null
) {

}