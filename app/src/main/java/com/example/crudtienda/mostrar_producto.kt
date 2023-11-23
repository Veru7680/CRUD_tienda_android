package com.example.crudtienda

import ProductAdapter
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class mostrar_producto : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var tvErrorMessage: TextView
    private lateinit var queue: RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mostrar_producto)

        recyclerView = findViewById(R.id.recyclerView)
        tvErrorMessage = findViewById(R.id.tvErrorMessage)

        queue = Volley.newRequestQueue(this)
        val url = "http://172.25.6.207:808/taller/negocioxy/php/listarproductojson.php"

        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                val productList = ArrayList<String>()

                for (i in 0 until response.length()) {
                    val jsonObject = response.getJSONObject(i)
                    productList.add(jsonObject.toString())
                }

                // Configurar el RecyclerView
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = ProductAdapter(productList)
            },
            Response.ErrorListener { error ->
                tvErrorMessage.text = "Error: ${error.message}"
            })

        queue.add(jsonArrayRequest)
    }
}
