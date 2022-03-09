package com.washlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.razorpay.Checkout
import org.json.JSONException
import org.json.JSONObject


class Payment: Fragment() {

    lateinit var checkout: Checkout
    private val model: MyViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkout = Checkout()
        checkout.setKeyID("rzp_test_rXV4iX0FfQ0rlE");
        Log.d("amount","${model.getTotalAmount()}")
    }

    override fun onStart() {
        super.onStart()
        val payObject  =  JSONObject()
        try {
            // to put name
            payObject.put("name", "WashList");

            // put description
            payObject.put("description", " payment");

            // to set theme color
            payObject.put("theme.color", "");

            // put the currency
            payObject.put("currency", "INR");

            // put amount
            payObject.put("amount", model.getTotalAmount());

            // put mobile number
            payObject.put("prefill.contact", "");

            // put email
            payObject.put("prefill.email", "");

            // open razorpay to checkout activity
            checkout.open(this.activity, payObject);
        } catch (e: JSONException) {

        }
    }

}
