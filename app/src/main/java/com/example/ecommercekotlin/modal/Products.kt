package com.example.ecommercekotlin.modal

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal
@Entity
@Parcelize
data class Products(
    val name: String,
    val description: String,
    val price: BigDecimal,
    val imagen: String? = null
) : Parcelable {

}