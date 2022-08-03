package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
//import io.grpc.Context

class DetailActitvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val txtNameLarge : TextView = findViewById(R.id.txtNameLarge)
        val txtPriceLarge : TextView = findViewById(R.id.txtPriceLarge)
        val txtDescription : TextView = findViewById(R.id.txtDescription)
        val imgPhotoLarge : ImageView = findViewById(R.id.imgPhotoLarge)
        val btnDetail : Button = findViewById(R.id.btnDetail)

        val i = intent

        val txtNameLargeDetail = i.getStringExtra("name")
        val txtPriceLargeDetail = i.getStringExtra("price")
        val txtDescriptionDetail = i.getStringExtra("description")
        val imgPhotoLargeDetail = i.getStringExtra("image")

        txtNameLarge.text = txtNameLargeDetail
        txtPriceLarge.text = txtPriceLargeDetail
        txtDescription.text = txtDescriptionDetail

        val storeRef: StorageReference = FirebaseStorage.getInstance().getReferenceFromUrl(imgPhotoLargeDetail.toString())
        Glide.with(imgPhotoLarge.context).load(storeRef).into(imgPhotoLarge)
        btnDetail.setOnClickListener{
            intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }

    }
}