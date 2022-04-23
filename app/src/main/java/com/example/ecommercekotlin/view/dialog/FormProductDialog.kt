package com.example.ecommercekotlin.view.dialog

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.example.ecommercekotlin.databinding.FormImagBinding
import com.example.ecommercekotlin.extensions.loaderImages

class FormProductDialog(private val context: Context) {


    fun showed(
        urlDefault: String? = null,
        loaderImageCarregada: (imagem: String) -> Unit
    ) {
        FormImagBinding.inflate(LayoutInflater.from(context)).apply {
            urlDefault?.let {
                formImg.loaderImages(it)
                editFormUrl.setText(it)
            }
            formBtnImageLoader.setOnClickListener {
                val url = editFormUrl.text.toString()
                formImg.loaderImages(url)
            }

            AlertDialog.Builder(context)
                .setView(root)
                .setPositiveButton("confirmar") { _, _ ->
                    val url = editFormUrl.text.toString()
                    loaderImageCarregada(url)
                }
                .setNegativeButton("Cancelar") { _, _ ->
                }
                .show()
        }
    }
}