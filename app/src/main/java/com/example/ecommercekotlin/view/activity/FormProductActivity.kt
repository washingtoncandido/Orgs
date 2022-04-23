package com.example.ecommercekotlin.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ecommercekotlin.DAO.ProductsDAO
import com.example.ecommercekotlin.databinding.ActivityFormproductBinding
import com.example.ecommercekotlin.extensions.loaderImages
import com.example.ecommercekotlin.modal.Products
import com.example.ecommercekotlin.view.dialog.FormProductDialog
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity() {

    private var url: String? = null
    private val binding by lazy {
        ActivityFormproductBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setTitle("Cadstro de Produto")


        configSalver()
        binding.imageViewCastro.setOnClickListener {
            FormProductDialog(this).showed(url){ imagem ->
                url = imagem
                binding.imageViewCastro.loaderImages(url)
            }
        }


    }

    private fun createProduct(): Products {
        val editName = binding.edtName
        val editDescripton = binding.edtDescripton
        val editPrice = binding.edtPrice
        val nome = editName.text.toString()
        val descripton = editDescripton.text.toString()
        val priceString = editPrice.text.toString()
        val price = if (priceString.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(priceString)
        }
        return Products(
            name = nome,
            description = descripton,
            price = price,
            imagen = url
        )


    }

    private fun configSalver() {
        val btn_salve = binding.btnCadastrar
        btn_salve.setOnClickListener {
            val productsDAO = ProductsDAO()
            productsDAO.addProduct(createProduct())
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}