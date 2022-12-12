package com.example.foodorderproject

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodorderproject.models.Pizza

class PizzaAdapter(
    val pizzaList: ArrayList<Pizza>,
    val itemClickListener: (Pizza) -> Unit,
) : RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return PizzaViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {

        val currentItem = pizzaList[position]
        val activity = holder.itemView.context as Activity

        holder.title.text = currentItem.title
        holder.description.text = currentItem.description
        holder.price.text = currentItem.price
        holder.itemView.setOnClickListener {
            itemClickListener(currentItem)
            val intent = Intent(activity, ProductDetails::class.java)
            intent.putExtra("img", pizzaList[position].img)
            intent.putExtra("title", pizzaList[position].title)
            intent.putExtra("description", pizzaList[position].description)
            intent.putExtra("price", pizzaList[position].price)
            intent.putExtra("position", position)
            activity.startActivity(intent)
        }
        Glide.with(holder.itemView.context).load(currentItem.img).into(holder.img)
    }

    override fun getItemCount(): Int {
        return pizzaList.size
    }

    class PizzaViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val title : TextView = itemView.findViewById(R.id.Heading)
        val description : TextView = itemView.findViewById(R.id.Heading1)
        val price : TextView = itemView.findViewById(R.id.button)
        val img : ImageView = itemView.findViewById(R.id.title_image)

    }

}