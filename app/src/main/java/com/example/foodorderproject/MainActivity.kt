package com.example.foodorderproject


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderproject.R.*
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<menu>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    lateinit var new_heading: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.main_page)

        val bottomNavigationView = findViewById<BottomNavigationView>(id.bottom_navigation)

        // Set Home selected
        bottomNavigationView.selectedItemId = id.home

        // Perform item selected listener

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                id.profile -> {
                    startActivity(Intent(applicationContext, ProfileActivity::class.java))
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                id.home -> return@OnNavigationItemSelectedListener true
                id.cart -> {
                    startActivity(Intent(applicationContext, CartActivity::class.java))
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })

        imageId = arrayOf(
            drawable.piczcza_pepperoni,
            drawable.piczcza_pepperoni,
            drawable.piczcza_pepperoni,
            drawable.piczcza_pepperoni,
            drawable.piczcza_pepperoni,
            drawable.piczcza_pepperoni,
            drawable.piczcza_pepperoni,
            drawable.piczcza_pepperoni,
            drawable.piczcza_pepperoni

        )

        heading = arrayOf(
            "Pizza Peperoni",
            "Pizza Peperoni",
            "Pizza Peperoni",
            "Pizza Peperoni",
            "Pizza Peperoni",
            "Pizza Peperoni",
            "Pizza Peperoni",
            "Pizza Peperoni",
            "Pizza Peperoni"
        )

        new_heading = arrayOf(
            "1",
            "Chicken pepperoni, extra mozzarella, tomatoes, tomato sauce",
            "Chicken pepperoni, extra mozzarella, tomatoes, tomato sauce",
            "Chicken pepperoni, extra mozzarella, tomatoes, tomato sauce",
            "Chicken pepperoni, extra mozzarella, tomatoes, tomato sauce",
            "Chicken pepperoni, extra mozzarella, tomatoes, tomato sauce",
            "Chicken pepperoni, extra mozzarella, tomatoes, tomato sauce",
            "Chicken pepperoni, extra mozzarella, tomatoes, tomato sauce",
            "Chicken pepperoni, extra mozzarella, tomatoes, tomato sauce"
        )

        newRecyclerView = findViewById(id.recycler_view)
        newRecyclerView.layoutManager = LinearLayoutManager (this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<menu>()
        getUserdata()
    }

    private fun getUserdata() {

        for (i in imageId.indices) {
            val Menu = menu(imageId[i],heading[i],new_heading[i])
            newArrayList.add(Menu)
        }

        newRecyclerView.adapter = myAdapter(newArrayList)
    }
}