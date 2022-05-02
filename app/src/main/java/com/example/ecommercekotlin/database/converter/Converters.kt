package com.example.ecommercekotlin.database.converter

import androidx.room.TypeConverter
import java.math.BigDecimal

class Converters {

    @TypeConverter
    fun deDouble(value: Double?): BigDecimal? {
        return value?.let { BigDecimal(value) } ?: BigDecimal.ZERO
    }

    @TypeConverter
    fun bigDecimalFromDouble(value: BigDecimal?): Double? {
        return value?.let { value.toDouble() }
    }
}