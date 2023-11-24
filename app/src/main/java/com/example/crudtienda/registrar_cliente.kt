package com.example.crudtienda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class registrar_cliente : AppCompatActivity() {

    private lateinit var edtNombre: EditText
    private lateinit var edtrut: EditText
    private lateinit var edtTelefono: EditText
    private lateinit var edtDireccion: EditText
    private lateinit var btnButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registrar_cliente)


        edtNombre = findViewById(R.id.Nombre)
        edtrut = findViewById(R.id.rut)
        edtTelefono = findViewById(R.id.Telefono)
        edtDireccion = findViewById(R.id.Direccion)
        btnButton = findViewById(R.id.button)

        btnButton.setOnClickListener {
            ejecutarServicio("http://172.25.6.207:808/taller/negocioxy/php/insertarFORM2.php")
        }
    }

    private fun ejecutarServicio(URL: String) {
        val stringRequest = object : StringRequest(Method.POST, URL,
            Response.Listener { response ->
                Toast.makeText(applicationContext, "OPERACION EXITOSA", Toast.LENGTH_SHORT).show()
            },
            Response.ErrorListener { error ->
                Toast.makeText(applicationContext, error.toString(), Toast.LENGTH_SHORT).show()
            }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String> {
                val parametros = HashMap<String, String>()
                parametros["Nombre"] = edtNombre.text.toString()
                parametros["rut"] = edtrut.text.toString()
                parametros["Telefono"] = edtTelefono.text.toString()
                parametros["Direccion"] = edtDireccion.text.toString()
                return parametros
            }
        }

        val requestQueue: RequestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
    }
}