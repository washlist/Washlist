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

class Cart: Fragment() {

    private val model: MyViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val rv = view.findViewById<RecyclerView>(R.id.rv_cart)
        Log.d("data","${model.cartData}")
        rv.layoutManager = LinearLayoutManager(this.context)
        val adapter = CartAdapter(model.cartData.toList())
        rv.adapter = adapter
        val address = view.findViewById<Button>(R.id.address)
        address.setOnClickListener {
            val f = Address()
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment, f)?.commit()
        }
        super.onViewCreated(view, savedInstanceState)
    }

}