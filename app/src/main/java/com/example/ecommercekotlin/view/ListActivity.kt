package com.example.ecommercekotlin.view

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercekotlin.R
import com.example.ecommercekotlin.modal.Products
import com.example.ecommercekotlin.view.recyclerview.adapter.ListProductAdapter
import java.math.BigDecimal

class ListActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listproducts)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        recyclerView.adapter = ListProductAdapter(
            context = this, products = listOf(
                Products(
                    name = "Cesta de frutas",
                    description = "Laranja,manga e maça",
                    price = BigDecimal("19.99")
                ),
                Products(
                    name = "Cesta de frutas",
                    description = "Coiaba,Manga e Maça",
                    price = BigDecimal("29.99")
                )
            )
        )
        recyclerView.layoutManager = LinearLayoutManager(this)

    }


    fun configRecycler() {


    }


}