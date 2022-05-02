package com.example.ecommercekotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ecommercekotlin.database.DAO.ProductDao
import com.example.ecommercekotlin.database.converter.Converters
import com.example.ecommercekotlin.modal.Products


@Database(entities = [Products::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        fun getInstanci(context: Context): AppDataBase {
            return Room.databaseBuilder(
                context,
                AppDataBase::class.java,
                "orgs.db"
            ).allowMainThreadQueries().build()
        }
    }

}