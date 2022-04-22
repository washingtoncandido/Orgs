package com.example.ecommercekotlin.DAO

import com.example.ecommercekotlin.modal.Products
import java.math.BigDecimal

class ProductsDAO {

    companion object {
        private val products: MutableList<Products> = mutableListOf()
    }

    //função criada para adicionar o produto na lista
    fun addProduct(product: Products) {
        products.add(product)
    }

    //toList é usada para criar uma copia dos dados
    fun searchAll(): List<Products> {
        return products.toList()
    }
}