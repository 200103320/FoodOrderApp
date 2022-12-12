package com.example.foodorderproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.foodorderproject.databinding.ProductDetailsBinding
import kotlinx.android.synthetic.main.product_details.*

class ProductDetails : AppCompatActivity() {
    private lateinit var binding: ProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titleImage = binding.imageView7
        val product_name = binding.textView11
        val product_description = binding.textView13
        val price = binding.textView12
        lateinit var size : String
        lateinit var type : String

        val buttonBig = binding.button3
        val buttonMid = binding.button5
        val buttonSmall = binding.button7
        val buttonTraditional = binding.button4
        val buttonOriginal = binding.button8
        val backButton = binding.buttonBack
        val cart = binding.button2

        val minus = binding.imageView8
        val plus = binding.imageView9
        var stringCount = binding.textView14.toString()

        val bundle : Bundle? = intent.extras

        val imageId = bundle?.getString("img")
        val heading = bundle?.getString("title")
        val new_heading = bundle?.getString("description")
        val position = bundle?.getInt("position")
        val prices = bundle?.getString("price")

        if (imageId != null) {
            Glide.with(this).load(imageId).into(titleImage)
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
        cart.setOnClickListener {
            Toast.makeText(this, "Added to Cart", Toast.LENGTH_SHORT).show()
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