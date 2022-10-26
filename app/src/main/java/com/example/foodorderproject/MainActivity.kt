package com.example.foodorderproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val getstarted: Button = findViewById(R.id.getstarted)
        getstarted.setOnClickListener {
            setContentView(R.layout.main_page)
        }
    }
}