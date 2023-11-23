package com.example.crudtienda

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn :Button =findViewById(R.id.button3)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, registrar_producto::class.java)
            startActivity(intent)
        }

        val btnBorrar :Button =findViewById(R.id.button4)
        btnBorrar.setOnClickListener {
            val intent: Intent = Intent(this, borrar_producto::class.java)
            startActivity(intent)

        }

        val btnActualizar :Button =findViewById(R.id.button5)
        btnActualizar.setOnClickListener {
            val intent: Intent = Intent(this, actualizar_producto::class.java)
            startActivity(intent)

        }

        val btnMostrar :Button =findViewById(R.id.button6)
        btnMostrar.setOnClickListener {
            val intent: Intent = Intent(this, mostrar_producto::class.java)
            startActivity(intent)

        }
}}