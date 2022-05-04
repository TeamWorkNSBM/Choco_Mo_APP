package com.example.choco_moapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ShopactivityActivity : AppCompatActivity() {
    lateinit var mRecyclerView = RecyclerView
    lateinit var mDatabase= DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopactivity)

        mDatabase=FirebaseDatabase.getInstance().getReference("Users")
        mRecyclerView= FindViewById(R.id.listview)
        logRecyclerView()
    }

    private fun logRecyclerView() {
        var FirebaseRecyclerAdapter = object FirebaseRecyclerAdapter<Users ,UsersViewHolder>(){

        }
    }

    class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}