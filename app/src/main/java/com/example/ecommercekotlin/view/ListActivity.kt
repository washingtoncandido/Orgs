package com.example.ecommercekotlin.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercekotlin.DAO.ProductsDAO
import com.example.ecommercekotlin.R
import com.example.ecommercekotlin.modal.Products
import com.example.ecommercekotlin.view.recyclerview.adapter.ListProductAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class ListActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listproducts)

        val dao = ProductsDAO()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        recyclerView.adapter = ListProductAdapter(
            context = this, products = dao.searchAll()
        )
        recyclerView.layoutManager = LinearLayoutManager(this)
        goFormProducts()
    }

    override fun onResume() {
        super.onResume()
    }

    fun goFormProducts() {
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this, FormProductActivity::class.java)
            startActivity(intent)
        }
    }


}