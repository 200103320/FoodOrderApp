package com.example.foodorderproject


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderproject.R.*
import com.example.foodorderproject.models.Pizza
import com.example.foodorderproject.room.RegistrationActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.*


class MainActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var recyclerView: RecyclerView
    private lateinit var pizzaArrayList: ArrayList<Pizza>
    private lateinit var newArrayList: ArrayList<Pizza>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.main_page)

        val bottomNavigationView = findViewById<BottomNavigationView>(id.bottom_navigation)
        val pizzaButton = findViewById<Button>(id.button2)
        val dessertsButton = findViewById<Button>(id.button4)
        val drinksButton = findViewById<Button>(id.button6)
        val regbutton = findViewById<Button>(id.button)

        bottomNavigationView.selectedItemId = id.home

        regbutton.setOnClickListener {
            startActivity(Intent(applicationContext, RegistrationActivity::class.java))
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                id.profile -> {
                    startActivity(Intent(applicationContext, RegistrationActivity::class.java))
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

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        pizzaArrayList = arrayListOf<Pizza>()
        getPizzaData()

        pizzaButton.setOnClickListener {
            recyclerView.smoothScrollToPosition(1)
        }
        dessertsButton.setOnClickListener {
            recyclerView.smoothScrollToPosition(5)
        }
        drinksButton.setOnClickListener {
            recyclerView.smoothScrollToPosition(8)
        }
    }
    private fun getPizzaData() {

        dbref = FirebaseDatabase.getInstance().getReference("Pizzas")

        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()) {

                    for (pizzaSnapshot in snapshot.children) {

                        val pizza = pizzaSnapshot.getValue(Pizza::class.java)
                        pizzaArrayList.add(pizza!!)

                    }
                    recyclerView.adapter = PizzaAdapter(pizzaArrayList){}


                }
            }

            override fun onCancelled(error: DatabaseError) {


            }

        })
    }

//        imageId = arrayOf(
//            drawable.chrizo_fresh,
//            drawable.pepperoni,
//            drawable.ham_cheese,
//            drawable.ham_mushrooms,
//            drawable.hawaian,
//            drawable.meat_mix,
//            drawable.hoemmade,
//            drawable.indeika,
//            drawable.mango,
//            drawable.cappu,
//            drawable.chocolate_shake,
//            drawable.cheesecake,
//            drawable.fondan1,
//            drawable.cookies,
//            drawable.cocacola,
//            drawable.cocacolazero,
//            drawable.fanta1,
//            drawable.sprite1,
//            drawable.water1,
//        )
//
//        heading = arrayOf(
//            "Chorizo Fresh",
//            "Pepperoni",
//            "",
//            "",
//            "Hawaiian",
//            "Meat Mix",
//            "Homemade",
//            "Turkey with cranberry sauce",
//            "",
//            "",
//            "Chocolate shake",
//            "Cheesecake",
//            "Fondan",
//            "Cookie",
//            "Coca-Cola",
//            "Coca-Cola Zero",
//            "Fanta",
//            "Sprite",
//            "Water",
//        )
//
//        new_heading = arrayOf(
//            "Tomato sauce, mozzarella, spicy chicken chorizo, sweet pepper",
//            "Chicken pepperoni, extra mozzarella, tomato sauce",
//            "",
//            "",
//            "Chicken ham, pineapples, mozzarella, tomato sauce",
//            "Turkey pastrami, spicy chicken chorizo, chicken ham, tomato sauce",
//            "Spicy chicken pepperoni, chicken ham, tomato sauce",
//            "Turkey, cranberry sauce, cranberries, red onion, alfredo sauce",
//            "",
//            "",
//            "Sweet drink based on milk and ice cream with branded cocoa",
//            "The favorite of the guests - the most delicate curd cheesecake",
//            "French dessert with crispy crust and melted chocolate filling",
//            "Chocolate cookie with icing",
//            "",
//            "",
//            "",
//            "",
//            "",
//        )
//
//        prices = arrayOf(
//            "2700 tg",
//            "2200 t",
//            "2500 t",
//            "2550 t",
//            "2600 t",
//            "2800 t",
//            "2400 t",
//            "2900 t",
//            "1800 t",
//            "1300 t",
//            "1400 t",
//            "900 t",
//            "1600 t",
//            "600 t",
//            "600 t",
//            "500 t",
//            "550 t",
//            "550 t",
//            "300 t",
//        )
//
//        newRecyclerView = findViewById(id.recycler_view)
//        newRecyclerView.layoutManager = LinearLayoutManager (this)
//        newRecyclerView.setHasFixedSize(true)
//
//        newArrayList = arrayListOf<menu>()
//        getUserdata()

}

//    private fun getUserdata() {
//
//        for (i in imageId.indices) {
//            val Menu = menu(imageId[i],heading[i],new_heading[i], prices[i])
//            newArrayList.add(Menu)
//        }
//
//        var adapter = MyAdapter(newArrayList)
//        newRecyclerView.adapter = adapter
//        adapter.setOnItemClickListener(object : MyAdapter.OnItemClickListener {
//            override fun onItemClick(position: Int) {
//
//                val intent = Intent(this@MainActivity, ProductDetails::class.java)
//                intent.putExtra("imageId", newArrayList[position].titleImage)
//                intent.putExtra("heading", newArrayList[position].heading)
//                intent.putExtra("new_heading", newArrayList[position].new_heading)
//                intent.putExtra("prices", newArrayList[position].prices)
//                intent.putExtra("position", position)
//                startActivity(intent)
//            }
//
//        })
//    }
