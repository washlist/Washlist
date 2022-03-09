package com.washlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.washlist.Entity.Item

class Home:  Fragment(),onDeleteItem,onAddItem{

    private val model: MyViewModel by activityViewModels()
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.rv_home)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        val adapter = HomeAdapter(model.homeData)
        adapter.setonAdd(this)
        adapter.setonDelete(this)
        recyclerView.adapter = this.activity?.let { adapter }
        val next = view.findViewById<Button>(R.id.next)
        next.setOnClickListener {
            val f = Vendor()
            try {
                activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment, f)?.commit()
            }
            catch (e: Exception){
                Log.d("error", e.toString())
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun notifyAdapter(){
        recyclerView.adapter?.notifyDataSetChanged()
    }

    override fun onDelete(position: Int) {
        if(model.homeData[position].qty>0)  model.homeData[position].qty--
        notifyAdapter()
    }

    override fun onAddItem(position: Int) {
        model.homeData[position].qty++
        notifyAdapter()
    }

}