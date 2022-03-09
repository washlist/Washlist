package com.washlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView

class VendorAdapter(val data: List<String>) :BaseAdapter() {

    lateinit var vendorOnClickListener: VendorOnClickListener

    override fun getCount() = data.size

    override fun getItem(position: Int) =  0

    override fun getItemId(position: Int): Long {
        return 0.toLong()
    }

    fun setVenderListener(vendorOnClickListener: VendorOnClickListener){
        this.vendorOnClickListener = vendorOnClickListener
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.vendor_item,parent,false)
        val itemImage = itemView.findViewById<ImageView>(R.id.vendorImage)
        val itemName = itemView.findViewById<TextView>(R.id.vendorName)
        val item = itemView.findViewById<FrameLayout>(R.id.vendorItem)
        item.setOnClickListener { vendorOnClickListener.setOnclickListener(position) }
        itemName.text = data[position]
//        val itemCount = itemView.findViewById<TextView>(R.id.itemCount)
        return itemView
    }
}