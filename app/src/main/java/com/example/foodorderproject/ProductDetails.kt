package com.example.foodorderproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.list_item.*
import kotlinx.android.synthetic.main.product_details.*

class ProductDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.product_details)
        super.onCreate(savedInstanceState)

        val titleImage = findViewById<ImageView>(R.id.imageView7)
        val product_name = findViewById<TextView>(R.id.textView11)
        val product_description = findViewById<TextView>(R.id.textView13)
        val price = findViewById<TextView>(R.id.textView12)

        val buttonBig = findViewById<Button>(R.id.button3)
        val buttonMid = findViewById<Button>(R.id.button5)
        val buttonSmall = findViewById<Button>(R.id.button7)
        val buttonTraditional = findViewById<Button>(R.id.button4)
        val buttonOriginal = findViewById<Button>(R.id.button8)
        val backButton = findViewById<Button>(R.id.button_back)

        val minus = findViewById<Button>(R.id.imageView8)
        val plus = findViewById<Button>(R.id.imageView9)
        var stringCount = findViewById<TextView>(R.id.textView14).toString()

        val bundle : Bundle? = intent.extras

        val imageId = bundle?.getInt("imageId")
        val heading = bundle?.getString("heading")
        val new_heading = bundle?.getString("new_heading")
        val position = bundle?.getInt("position")
        val prices = bundle?.getString("prices")

        if (imageId != null) {
            titleImage.setImageResource(imageId)
        }
        product_name.text = heading
        product_description.text = new_heading
        price.text = prices

        if (position != null) {
            if(position > 7) {
                constr1.visibility = View.GONE
            }
        }


        var count = 1

        backButton.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }

        buttonBig.setOnClickListener {
            buttonMid.setBackgroundResource(R.drawable.pizza_size_button)
            buttonSmall.setBackgroundResource(R.drawable.pizza_size_button)
            buttonBig.setBackgroundResource(R.drawable.pizza_size_button_selected)
        }
        buttonMid.setOnClickListener {
            buttonMid.setBackgroundResource(R.drawable.pizza_size_button_selected)
            buttonSmall.setBackgroundResource(R.drawable.pizza_size_button)
            buttonBig.setBackgroundResource(R.drawable.pizza_size_button)
        }
        buttonSmall.setOnClickListener {
            buttonSmall.setBackgroundResource(R.drawable.pizza_size_button_selected)
            buttonMid.setBackgroundResource(R.drawable.pizza_size_button)
            buttonBig.setBackgroundResource(R.drawable.pizza_size_button)
        }
        buttonTraditional.setOnClickListener {
            buttonTraditional.setBackgroundResource(R.drawable.pizza_size_button_selected)
            buttonOriginal.setBackgroundResource(R.drawable.pizza_size_button)
        }
        buttonOriginal.setOnClickListener {
            buttonTraditional.setBackgroundResource(R.drawable.pizza_size_button)
            buttonOriginal.setBackgroundResource(R.drawable.pizza_size_button_selected)
        }
        minus.setOnClickListener {
            if(count > 1) {
                count --
                textView14.text = count.toString()
            }
        }
        plus.setOnClickListener {
            count ++
            textView14.text = count.toString()
        }
    }

}