package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.HomeActivity
import com.example.myapplication.R

class FinalActivity : AppCompatActivity() {
    lateinit var finalBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.final_page)

        finalBtn = findViewById(R.id.finalBtn)
        finalBtn.setOnClickListener {
            intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}