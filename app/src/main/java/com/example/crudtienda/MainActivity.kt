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

        val btn1 :Button =findViewById(R.id.btnCrudProducto)
        btn1.setOnClickListener {
            val intent: Intent = Intent(this, crud_producto::class.java)
            startActivity(intent)
        }

        val btn2 :Button =findViewById(R.id.btnCrudCliente)
        btn2.setOnClickListener {
            val intent: Intent = Intent(this, crud_cliente::class.java)
            startActivity(intent)
        }

        val btn3 :Button =findViewById(R.id.btnCrudProveedor)
        btn3.setOnClickListener {
            val intent: Intent = Intent(this, crud_proveedor::class.java)
            startActivity(intent)
        }





    }}