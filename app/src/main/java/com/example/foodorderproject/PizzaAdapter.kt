package com.example.foodorderproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodorderproject.models.Pizza

class PizzaAdapter(private val context: android.content.Context, val pizzaList: ArrayList<Pizza>) : RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>() {


    private lateinit var mListener : PizzaAdapter.OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: PizzaAdapter.OnItemClickListener){

        mListener = listener

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return PizzaViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {

        val currentItem = pizzaList[position]

        holder.title.text = currentItem.title
        holder.description.text = currentItem.description
        holder.price.text = currentItem.price
        Glide.with(context).load(currentItem.img).into(holder.img)
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
