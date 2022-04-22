package com.example.ecommercekotlin.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.ecommercekotlin.DAO.ProductsDAO
import com.example.ecommercekotlin.R
import com.example.ecommercekotlin.modal.Products
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formproduct)
        setTitle("Cadstro de Produto")

        val btn_salve = findViewById<Button>(R.id.btn_cadastrar)
        btn_salve.setOnClickListener {

            val editName = findViewById<EditText>(R.id.edt_name)
            val editDescripton = findViewById<EditText>(R.id.edt_descripton)
            val editPrice = findViewById<EditText>(R.id.edt_price)

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


    private fun getField() {

    }
}