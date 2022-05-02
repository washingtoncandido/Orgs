package com.example.ecommercekotlin.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommercekotlin.R
import com.example.ecommercekotlin.database.AppDataBase
import com.example.ecommercekotlin.databinding.ActivityListproductsBinding
import com.example.ecommercekotlin.modal.Products
import com.example.ecommercekotlin.view.recyclerview.adapter.ListProductAdapter

class ListActivity : AppCompatActivity(), ListProductAdapter.onItemClick {

    private val adapter by lazy {
        ListProductAdapter(context = this, clickProduct = this)
    }
    private val binding by lazy {
        ActivityListproductsBinding.inflate(layoutInflater)
    }
    private val productDAO by lazy {
        AppDataBase.getInstanci(this).productDao()
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
        adapter.attAllProduts(productDAO.searchAllNameAsc())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_list_product, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_name_desc -> {
                adapter.attAllProduts(productDAO.searchAllNameDesc())
            }
            R.id.menu_name_asc -> {
                adapter.attAllProduts(productDAO.searchAllNameAsc())
            }
            R.id.menu_description_desc -> {
                adapter.attAllProduts(productDAO.searchAllDescriptionDesc())
            }
            R.id.menu_description_asc -> {
                adapter.attAllProduts(productDAO.searchAllDescriptionAsc())
            }
            R.id.menu_price_desc -> {
                adapter.attAllProduts(productDAO.searchAllPriceDesc())
            }
            R.id.menu_price_asc -> {
                adapter.attAllProduts(productDAO.searchAllPriceAsc())
            }
            R.id.menu_never_order -> {
                adapter.attAllProduts(productDAO.searchAll())
            }
        }
        return super.onOptionsItemSelected(item)
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
        val intent = Intent(this, DetailProductActivity::class.java)
        intent.putExtra(KEY_PRODUCT_ID, product.id)
        startActivity(intent)
    }


}