package com.example.crudtienda

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class crud_proveedor : AppCompatActivity() {



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.crud_proveedor)
        val btn :Button =findViewById(R.id.button3)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, registra_proveedor::class.java)
            startActivity(intent)
        }
        val btnBorrar :Button =findViewById(R.id.button4)
        btnBorrar.setOnClickListener {
            val intent: Intent = Intent(this, borrar_proveedor::class.java)
            startActivity(intent)

        }


    }}