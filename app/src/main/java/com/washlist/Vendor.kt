package com.washlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Vendor: Fragment() ,VendorOnClickListener{

    private val model: MyViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.vendor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val rv = view.findViewById<GridView>(R.id.rv_vendor)
        val adapter = VendorAdapter(model.vendorData)
        adapter.setVenderListener(this)
        rv.adapter = adapter
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setOnclickListener(position: Int) {
        model.selectedVendor = position
        val f = Cart()
        model.setCartData()
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment, f)?.commit()
    }
}