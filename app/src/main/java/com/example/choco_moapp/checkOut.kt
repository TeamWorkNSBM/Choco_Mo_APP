package com.example.choco_moapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.ShapeAppearanceModel

class checkOut : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R layout.activity_check_out)
        val search= findViewById<TextView>(R.id.main_search)
        val shapeable= findViewById<ShapeableImageView>(R.id.main_shapeable)
        val recyclerView= findViewById<RecyclerView>(R.id.main_recyclerView)

        shapeable.shapeAppearanceModel= ShapeAppearanceModel().toBuilder().setAllCorners(
            CornerFamily.ROUNDED, 20F).build()

        val itemList= ArrayList<Category>()
        val adapter= CategoryAdapter(itemList)

        setupRecyclerView(adapter,recyclerView)

        val db= FirebaseDatabase.getInstance().reference
        val valueEventListener= object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for(i in snapshot.children){
                    itemList.add(Category(i.key.toString(), i.child("image").getValue().toString()))
                }
                adapter.notifyDataSetChanged()
            }

    }
}