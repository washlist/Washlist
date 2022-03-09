package com.washlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.washlist.Entity.AddressItem

class Address: Fragment() {

    private val model: MyViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.address, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val customerName = view.findViewById<EditText>(R.id.text_address_username)
        val phoneNumber = view.findViewById<EditText>(R.id.text_address_mobile)
        val houseNo = view.findViewById<EditText>(R.id.text_address_flat_number)
        val landmark = view.findViewById<EditText>(R.id.text_address_landmark)
        val next = view.findViewById<Button>(R.id.goToPayment)
        next.setOnClickListener {
            model.addressItem = AddressItem(customerName.text.toString(), phoneNumber.text.toString()
                    ,houseNo.text.toString(),landmark.text.toString())

            Log.d("payment","payment")
            val f = Payment()
            try {
                activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment, f)?.commit()
            }
            catch (e: Exception){
                Log.d("error","${e.toString()}")
            }

        }
        super.onViewCreated(view, savedInstanceState)
    }
}