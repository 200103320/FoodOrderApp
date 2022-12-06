package com.example.foodorderproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import coil.load
import com.example.foodorderproject.databinding.FragmentProfileBinding
import com.example.foodorderproject.databinding.ProductDetailsBinding
import com.example.foodorderproject.room.UserDatabase
import com.example.foodorderproject.room.UserEntity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: FragmentProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.profileImage.load("")
        val bottomNavigationView = binding.bottomNavigation

        val db = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java, "UserDatabase"
        ).fallbackToDestructiveMigration().build()



        // Set Home selected
        bottomNavigationView.selectedItemId = R.id.profile

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.cart -> {
                    startActivity(Intent(applicationContext, CartActivity::class.java))
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.profile -> return@OnNavigationItemSelectedListener true
                R.id.home -> {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
    }
}