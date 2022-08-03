package com.example.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class ProductAdapter(options: FirebaseRecyclerOptions<Product>)
    : FirebaseRecyclerAdapter<Product, ProductAdapter.MyViewHolder>(options){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int,
        model: Product
    ) {
        val storeRef: StorageReference = FirebaseStorage.getInstance().getReferenceFromUrl(model.image)
        Glide.with(holder.imgPhoto.context).load(storeRef).into(holder.imgPhoto)
        holder.txtName.text = "" + model.name
        holder.txtPrice.text = "Price: $" + model.price.toString()

        holder.itemView.setOnClickListener{
            val context = it.context
            val intent = Intent(context, DetailActitvity::class.java)
            intent.putExtra("name", model.name)
            intent.putExtra("description", model.description)
            intent.putExtra("price", model.price.toString())
            intent.putExtra("image", model.image)

            context.startActivity(intent)
        }
    }

    class MyViewHolder(inflater: LayoutInflater, parent: ViewGroup)
        : RecyclerView.ViewHolder(inflater.inflate(R.layout.row_layout, parent, false)){
            val txtName: TextView = itemView.findViewById(R.id.txtName)
            val txtPrice: TextView = itemView.findViewById(R.id.txtPrice)
            val imgPhoto: ImageView = itemView.findViewById(R.id.imgPhoto)
        }
}
