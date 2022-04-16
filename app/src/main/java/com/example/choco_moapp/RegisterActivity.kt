package com.example.choco_moapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        auth = FirebaseAuth.getInstance();

        RegisterBtn1.setOnClickListener {
            if (editEmail.text.isNotEmpty() || editPassword.text.isNotEmpty() || editCPassword.text.isNotEmpty()) {
                registerUser();
            } else {
                Toast.makeText(this, "Input Required", Toast.LENGTH_LONG).show()

            }
        }
        tvlogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent)
        }
    }
    fun registerUser(){

        auth.createUserWithEmailAndPassword(editEmail.text.trim().toString(),editPassword.text.trim().toString())
            .addOnCompleteListener(this){
                task ->
                if(task.isSuccessful){
                    Toast.makeText(this, "Register successfull", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Register failed"+task.exception, Toast.LENGTH_LONG).show()

                }
            }
    }

    override fun onStart() {
        super.onStart()

            val user = auth.currentUser;

//            if (user != null) {
//                val intent = Intent(this, ShopactivityActivity::class.java);
//                startActivity(intent)
//
//            } else {
//                Log.e("user status", "user null")
//            }

        }
    }

