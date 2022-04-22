package com.example.ecommercekotlin.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.ecommercekotlin.DAO.ProductsDAO
import com.example.ecommercekotlin.R
import com.example.ecommercekotlin.databinding.ActivityFormproductBinding
import com.example.ecommercekotlin.databinding.ActivityListproductsBinding
import com.example.ecommercekotlin.modal.Products
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormproductBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setTitle("Cadstro de Produto")

        val btn_salve = binding.btnCadastrar
        btn_salve.setOnClickListener {
            val editName = binding.edtName
            val editDescripton = binding.edtDescripton
            val editPrice = binding.edtPrice

            val nome = editName.text.toString()
            val descripton = editDescripton.text.toString()
            val priceString = editPrice.text.toString()

            val price = ConvertBigDecimal(priceString)

            val products = Products(
                name = nome,
                description = descripton,
                price = price
            )
            Log.i("FormularioProduct", "Novo Produto Criado : $products")

            val productsDAO = ProductsDAO()
            productsDAO.addProduct(products)
            Log.i("FormularioProduct", "Novo Produto Criado : ${productsDAO.searchAll()}")
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

    private fun ConvertBigDecimal(valor: String): BigDecimal? {
        val valor = if (valor.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valor)
        }
        return valor
    }



}