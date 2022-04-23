package com.example.ecommercekotlin.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

fun formatAmountBrazil(value: BigDecimal): String {
    val formatNumber: NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
    return formatNumber.format(value)
}