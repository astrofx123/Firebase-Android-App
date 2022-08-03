package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CheckoutActivity : AppCompatActivity() {
    lateinit var checkoutBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checkout_form)

        checkoutBtn = findViewById(R.id.checkoutBtn)
        checkoutBtn.setOnClickListener {
            intent = Intent(this, FinalActivity::class.java)
            startActivity(intent)
        }
    }
}