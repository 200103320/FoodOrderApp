package com.example.foodorderproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView


class MyAdapter(private val menuList : ArrayList<menu>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    private lateinit var mListener : OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }


    fun setOnItemClickListener(listener: OnItemClickListener){
        
        mListener = listener
        
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = menuList [position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.heading.text = currentItem.heading
        holder.heading1.text = currentItem.new_heading
        holder.prices.text = currentItem.prices
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    class MyViewHolder( itemView : View, listener: OnItemClickListener) :  RecyclerView.ViewHolder(itemView){
        val titleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val heading : TextView = itemView.findViewById(R.id.Heading)
        val heading1 : TextView = itemView.findViewById(R.id.Heading1)
        val prices : TextView = itemView.findViewById(R.id.button)

        init {

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }
    }

}