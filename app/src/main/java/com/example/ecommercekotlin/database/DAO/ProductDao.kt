package com.example.ecommercekotlin.database.DAO

import androidx.room.*
import com.example.ecommercekotlin.modal.Products

@Dao
interface ProductDao {

    @Query("SELECT * FROM Products")
    fun searchAll(): List<Products>

    @Query("SELECT * FROM Products ORDER BY name DESC")
    fun searchAllNameDesc(): List<Products>


    @Query("SELECT * FROM Products ORDER BY name ASC")
    fun searchAllNameAsc(): List<Products>

    @Query("SELECT * FROM Products ORDER BY description DESC")
    fun searchAllDescriptionDesc(): List<Products>

    @Query("SELECT * FROM Products ORDER BY description ASC")
    fun searchAllDescriptionAsc(): List<Products>

    @Query("SELECT * FROM Products ORDER BY price DESC")
    fun searchAllPriceDesc(): List<Products>

    @Query("SELECT * FROM Products ORDER BY price ASC")
    fun searchAllPriceAsc(): List<Products>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addProduct(vararg product: Products)

    @Delete()
    fun deletProduct(vararg products: Products)


    @Query("SELECT * FROM Products WHERE id = :id")
    fun searchId(id: Long): Products?
}