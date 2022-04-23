package com.example.ecommercekotlin.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommercekotlin.DAO.ProductsDAO
import com.example.ecommercekotlin.DetailProductActivity
import com.example.ecommercekotlin.databinding.ActivityListproductsBinding
import com.example.ecommercekotlin.modal.Products
import com.example.ecommercekotlin.view.recyclerview.adapter.ListProductAdapter

class ListActivity : Activity(), ListProductAdapter.ClickProduct {

    private val dao = ProductsDAO()


    private val adapter by lazy {
        ListProductAdapter(this, products = dao.searchAll(),this)
    }
    private val binding by lazy {
        ActivityListproductsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configRecyclerView()
        onClickFab()
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        onClickFab()
        adapter.attAllProduts(dao.searchAll())
    }

    private fun configRecyclerView() {
        val recyclerView = binding.recycler
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    fun goFormProducts() {
        val intent = Intent(this, FormProductActivity::class.java)
        startActivity(intent)

    }

    private fun onClickFab() {
        val fab = binding.floatingActionButton
        fab.setOnClickListener {
            goFormProducts()
        }
    }

    override fun clickProduct(product: Products) {

        val intent = Intent(this, DetailProductActivity::class.java).apply {
            putExtra("KEY",product)
        }

        startActivity(intent)
    }


}