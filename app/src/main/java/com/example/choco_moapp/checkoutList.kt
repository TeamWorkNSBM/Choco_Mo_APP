package com.example.choco_moapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class checkoutList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout_list)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(itemList[position].image).resize(1000, 491).into(holder.image)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView){
        val image: ImageView

        init {
            image= itemView.findViewById(R.id.checkoutList)
        }
    }
}