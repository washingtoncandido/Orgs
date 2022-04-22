package com.example.ecommercekotlin.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercekotlin.DAO.ProductsDAO
import com.example.ecommercekotlin.R
import com.example.ecommercekotlin.view.recyclerview.adapter.ListProductAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListActivity : Activity() {

    private val dao = ProductsDAO()
    private val adapter = ListProductAdapter(context = this, products = dao.searchAll())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listproducts)
        configRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        onClickFab()
        adapter.attAllProduts(dao.searchAll())
    }

    private fun configRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    fun goFormProducts() {
        val intent = Intent(this, FormProductActivity::class.java)
        startActivity(intent)

    }

    private fun onClickFab() {
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            goFormProducts()
        }
    }


}