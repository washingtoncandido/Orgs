package com.example.ecommercekotlin.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ecommercekotlin.database.AppDataBase
import com.example.ecommercekotlin.databinding.ActivityFormproductBinding
import com.example.ecommercekotlin.extensions.loaderImages
import com.example.ecommercekotlin.modal.Products
import com.example.ecommercekotlin.view.dialog.FormProductDialog
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity() {

    private var url: String? = null
    private var productId = 0L

    private val binding by lazy {
        ActivityFormproductBinding.inflate(layoutInflater)
    }
    private val productDAO by lazy {
        AppDataBase.getInstanci(this).productDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setTitle("Cadstro de Produto")
        configSalver()
        binding.imageViewCastro.setOnClickListener {
            FormProductDialog(this).showed(url) { imagem ->
                url = imagem
                binding.imageViewCastro.loaderImages(url)
            }
        }
        loadProduct()
    }

    private fun loadProduct() {
        productId = intent.getLongExtra(KEY_PRODUCT_ID, 0)
    }

    override fun onResume() {
        super.onResume()
        serachProduct()
    }

    private fun serachProduct() {
        productDAO.searchId(productId)?.let {
            title = "alterando Produto"
            preencheCamps(it)
        }
    }

    private fun preencheCamps(products: Products) {
        with(binding) {
            url = products.imagen
            binding.imageViewCastro.loaderImages(products.imagen)
            edtName.setText(products.name)
            edtDescripton.setText(products.description)
            edtPrice.setText(products.price.toPlainString())
            binding.btnCadastrar.text = "Atualizar"
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
            id = productId,
            name = nome,
            description = descripton,
            price = price,
            imagen = url
        )
    }

    private fun configSalver() {
        val btn_salve = binding.btnCadastrar

        btn_salve.setOnClickListener {
            val productNew = createProduct()
            productDAO.addProduct(productNew)
            finish()
        }
    }


}