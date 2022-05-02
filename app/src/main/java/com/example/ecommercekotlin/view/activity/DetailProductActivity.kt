package com.example.ecommercekotlin.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.ecommercekotlin.R
import com.example.ecommercekotlin.database.AppDataBase
import com.example.ecommercekotlin.databinding.ActivityDetailProductBinding
import com.example.ecommercekotlin.extensions.formatValueBrazil
import com.example.ecommercekotlin.extensions.loaderImages
import com.example.ecommercekotlin.modal.Products

class DetailProductActivity : AppCompatActivity() {
    private var productDetail: Products? = null
    private var productId: Long = 0L

    private val productDAO by lazy {
        AppDataBase.getInstanci(this).productDao()
    }
    private val binding by lazy {
        ActivityDetailProductBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setTitle("Detalhes")
        loadProduct()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail_product, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onResume() {
        super.onResume()
        searchProductBank()
    }

    private fun searchProductBank() {
        productDetail = productDAO.searchId(productId)
        productDetail?.let { preencheCamps(it) } ?: finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_detail_product_remov -> {
                productDetail?.let {
                    productDAO.deletProduct(it)
                }
                finish()
            }
            R.id.menu_detail_product_edit -> {
                val intent = Intent(this, FormProductActivity::class.java)
                intent.putExtra(KEY_PRODUCT_ID, productId)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun loadProduct() {
        productId = intent.getLongExtra(KEY_PRODUCT_ID, 0L)
    }

    private fun preencheCamps(products: Products) {

        with(binding) {
            activityDetalhesBanners.loaderImages(products.imagen)
            activityDetalhesTitulo.text = products.name
            activityDetalhesDescri.text = products.description
            activityDetalhesTextValor.text = products.price.formatValueBrazil()
        }
    }
}
