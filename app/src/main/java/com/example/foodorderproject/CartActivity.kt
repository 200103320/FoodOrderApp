package com.example.foodorderproject

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderproject.R.*
import com.example.foodorderproject.databinding.CartItemBinding
import com.example.foodorderproject.databinding.FragmentCartBinding
import com.example.foodorderproject.databinding.ProductDetailsBinding
import com.example.foodorderproject.models.Cart
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_cart.*


class CartActivity : AppCompatActivity() {
    private lateinit var cartArrayList: ArrayList<Cart>
    private lateinit var binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCartBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val newRecyclerView = recycler_view
        newRecyclerView.layoutManager = LinearLayoutManager (this)
        newRecyclerView.setHasFixedSize(true)

//        val bundle : Bundle? = intent.extras
        cartArrayList = arrayListOf<Cart>()

        val arrList = intent?.getParcelableArrayListExtra<Cart>("cartArr")
        val car1 = Cart("chorizo", "Big", "Traditional",
            "https://dodopizza-a.akamaihd.net/static/Img/Products/63aa5567d9244d8989c38c6defc3f10d_292x292.webp",
            "300 t", 2)
        if (arrList == null) {
            cartArrayList.add(car1)
        }else{
            cartArrayList = arrList
        }
        val total = intent.getStringExtra("total")
        binding.total.text = "Make an order for " + total + " tg"

        recycler_view.adapter = CartAdapter(cartArrayList)
        val but = findViewById<Button>(id.but)
        but.setOnClickListener {
            Toast.makeText(this, " "+cartArrayList, Toast.LENGTH_SHORT).show()
        }

        // Initialize and assign variable
        val bottomNavigationView = findViewById<BottomNavigationView>(id.bottom_navigation)

        // Set Home selected
        bottomNavigationView.selectedItemId = id.cart

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                id.home -> {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                id.cart -> return@OnNavigationItemSelectedListener true
                id.profile -> {
                    startActivity(Intent(applicationContext, ProfileActivity::class.java))
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
    }
}