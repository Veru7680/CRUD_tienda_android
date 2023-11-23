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

// ...

class actualizar_producto : AppCompatActivity() {

    private lateinit var edtNombre: EditText
    private lateinit var edtPrecio: EditText
    private lateinit var edtStock: EditText
    private lateinit var edtIdCategoria: EditText
    private lateinit var edtIdProducto: EditText
    private lateinit var btnButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actualizar_producto)

        edtNombre = findViewById(R.id.Nombre)
        edtPrecio = findViewById(R.id.precio)
        edtStock = findViewById(R.id.Stock)
        edtIdCategoria = findViewById(R.id.idCategoria)
        edtIdProducto = findViewById(R.id.idProducto)  // Nuevo EditText para el ID
        btnButton = findViewById(R.id.button)

        btnButton.setOnClickListener {
            ejecutarServicio("http://172.25.6.207:808/taller/negocioxy/php/actualizar2.php")
        }
    }

    private fun ejecutarServicio(URL: String) {
        val stringRequest = object : StringRequest(Method.POST, URL,
            Response.Listener { response ->
                Toast.makeText(applicationContext, "OPERACION EXITOSA", Toast.LENGTH_SHORT).show()
                // Puedes agregar lógica adicional después de una operación exitosa si es necesario
            },
            Response.ErrorListener { error ->
                Toast.makeText(applicationContext, error.toString(), Toast.LENGTH_SHORT).show()
            }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String> {
                val parametros = HashMap<String, String>()
                parametros["ID"] = edtIdProducto.text.toString()
                parametros["Nombre"] = edtNombre.text.toString()
                parametros["Precio"] = edtPrecio.text.toString()
                parametros["Stock"] = edtStock.text.toString()
                parametros["IdCategoria"] = edtIdCategoria.text.toString()
                return parametros
            }
        }

        val requestQueue: RequestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
    }
}

