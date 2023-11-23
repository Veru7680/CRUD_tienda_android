package com.example.crudtienda

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class borrar_producto : AppCompatActivity() {

    private lateinit var edtIdProducto: EditText
    private lateinit var btnEliminar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.borrar_producto)

        edtIdProducto = findViewById(R.id.edtIdProducto)
        btnEliminar = findViewById(R.id.btnEliminar)

        btnEliminar.setOnClickListener {
            ejecutarServicio("http://172.25.6.207:808/taller/negocioxy/php/borrar2.php")
        }
    }

    private fun ejecutarServicio(URL: String) {
        val stringRequest = object : StringRequest(Method.POST, URL,
            Response.Listener { response ->
                Toast.makeText(applicationContext, "PRODUCTO ELIMINADO EXITOSAMENTE", Toast.LENGTH_SHORT).show()
            },
            Response.ErrorListener { error ->
                Toast.makeText(applicationContext, error.toString(), Toast.LENGTH_SHORT).show()
            }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String> {
                val parametros = HashMap<String, String>()
                parametros["ID_borrar"] = edtIdProducto.text.toString()
                return parametros
            }
        }

        val requestQueue: RequestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
    }
}
