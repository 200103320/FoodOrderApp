package com.example.foodorderproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodorderproject.models.Cart
import com.google.android.material.imageview.ShapeableImageView

class CartAdapter(private val cartList : ArrayList<Cart>) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    var total = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.cart_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val currentItem = cartList[position]

        holder.heading.text = currentItem.title
        Glide.with(holder.itemView.context).load(currentItem.img).into(holder.titleImage)
        holder.type.text = currentItem.type
        holder.size.text = currentItem.size
        holder.count.text = currentItem.count.toString()
        holder.prices.text = currentItem.price
    }

    override fun getItemCount(): Int {
        return cartList.size
    }

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val heading : TextView = itemView.findViewById(R.id.Heading)
        val type : TextView = itemView.findViewById(R.id.heading2)
        val size : TextView = itemView.findViewById(R.id.heading3)
        val prices : TextView = itemView.findViewById(R.id.price)
        val count : TextView = itemView.findViewById(R.id.textView14)
    }
}

class DiffCallback : DiffUtil.ItemCallback<Cart>() {
    override fun areContentsTheSame(oldItem: Cart, newItem: Cart): Boolean {
        TODO("Not yet implemented")
    }

    override fun areItemsTheSame(oldItem: Cart, newItem: Cart): Boolean {
        TODO("Not yet implemented")
    }
}