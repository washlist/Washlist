package com.washlist

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.washlist.Entity.CartItem

class CartAdapter (val data: List<CartItem>) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("size" ,"$position")
        holder.itemName.text = data[position].itemName.name
        holder.itemCount.text = data[position].qty.toString()
        holder.itemPrice.text = data[position].price.toString()
    }

    override fun getItemCount() = data.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val itemImage = itemView.findViewById<ImageView>(R.id.itemImage)
        val itemName = itemView.findViewById<TextView>(R.id.itemName)
        val itemCount = itemView.findViewById<TextView>(R.id.itemCount)
        val itemPrice = itemView.findViewById<TextView>(R.id.itemPrice)
    }
}