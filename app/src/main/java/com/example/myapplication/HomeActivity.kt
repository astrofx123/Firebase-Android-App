package com.example.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ProductAdapter
import com.example.myapplication.R
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase

class HomeActivity : AppCompatActivity() {
    private var rView: RecyclerView? = null
    private var adapter: ProductAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val query = FirebaseDatabase.getInstance().reference.child("books")
        val options = FirebaseRecyclerOptions.Builder<Product>().setQuery(query, Product::class.java).build()
        adapter = ProductAdapter(options)

        rView = findViewById(R.id.rView)
        rView?.layoutManager = LinearLayoutManager(this)
        rView?.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        adapter?.startListening()
    }
}
