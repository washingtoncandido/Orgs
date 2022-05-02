package com.example.ecommercekotlin.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

fun BigDecimal.formatValueBrazil(): String {
    val formatNumber: NumberFormat = NumberFormat
        .getCurrencyInstance(Locale("pt", "br"))
    return formatNumber.format(this)
}