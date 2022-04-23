package com.example.ecommercekotlin

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.example.ecommercekotlin.extensions.formatAmountBrazil
import com.example.ecommercekotlin.modal.Products

class DetailProductActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)

        val productDestail: Products? = intent.getParcelableExtra<Products>("KEY")
        if (productDestail != null) {
            val descripton = findViewById<TextView>(R.id.activity_detalhes_descri)
            val image = findViewById<ImageView>(R.id.activity_detalhes_banners)
            val title = findViewById<TextView>(R.id.activity_detalhes_titulo)
            val price = findViewById<TextView>(R.id.activity_detalhes_text_valor)
            val formatAmount: String? = formatAmountBrazil(productDestail.price)
            image.load(productDestail.imagen)
            title.text = productDestail.name
            descripton.text = productDestail.description
            price.text = formatAmount

        }
    }
}