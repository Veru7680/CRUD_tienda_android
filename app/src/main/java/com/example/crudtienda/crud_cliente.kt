package com.example.crudtienda

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class crud_cliente : AppCompatActivity() {



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.crud_cliente)
        val btn :Button =findViewById(R.id.button3)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, registrar_cliente::class.java)
            startActivity(intent)
        }


    }}