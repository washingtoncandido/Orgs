package com.example.ecommercekotlin.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercekotlin.DAO.ProductsDAO
import com.example.ecommercekotlin.R
import com.example.ecommercekotlin.databinding.ActivityListproductsBinding
import com.example.ecommercekotlin.view.recyclerview.adapter.ListProductAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListActivity : Activity() {

    private val dao = ProductsDAO()


    private val adapter by lazy {
        ListProductAdapter(this, products = dao.searchAll())
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


}