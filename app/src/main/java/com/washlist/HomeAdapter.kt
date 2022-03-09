package com.washlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.washlist.Entity.Item

class HomeAdapter(val data: List<Item>): RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    lateinit var onAddItem: onAddItem

    lateinit var onDeleteItem: onDeleteItem

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_item,parent,false)
        return ViewHolder(view)
    }

    fun setonAdd(onAddItem: onAddItem){
        this.onAddItem = onAddItem
    }

    fun setonDelete(onDeleteItem: onDeleteItem){
        this.onDeleteItem = onDeleteItem
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemName.text = data[position].itemName.name
        holder.plus.setOnClickListener {
            onAddItem.onAddItem(position)
        }
        holder.minus.setOnClickListener {
            onDeleteItem.onDelete(position)
        }
        holder.itemCount.text = data[position].qty.toString()
    }

    override fun getItemCount() = data.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val itemImage = itemView.findViewById<ImageView>(R.id.itemImage)
        val itemName = itemView.findViewById<TextView>(R.id.itemName)
        val itemCount = itemView.findViewById<TextView>(R.id.itemCount)
        val plus = itemView.findViewById<ImageView>(R.id.plus)
        val minus = itemView.findViewById<ImageView>(R.id.minus)
    }

}