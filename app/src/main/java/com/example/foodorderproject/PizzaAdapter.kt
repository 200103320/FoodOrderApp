package com.example.foodorderproject

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderproject.models.Pizza
import kotlinx.android.synthetic.main.list_item.view.*

class PizzaAdapter(private val pizzaList : ArrayList<Pizza>) : RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return PizzaViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {

        val currentItem = pizzaList[position]

        holder.title.text = currentItem.title
        holder.description.text = currentItem.description
        holder.price.text = currentItem.price

    }

    override fun getItemCount(): Int {
        return pizzaList.size
    }

    class PizzaViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val title : TextView = itemView.findViewById(R.id.Heading)
        val description : TextView = itemView.findViewById(R.id.Heading1)
        val price : TextView = itemView.findViewById(R.id.button)


    }

}
