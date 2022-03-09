package com.washlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.razorpay.PaymentResultListener

class MainActivity : AppCompatActivity() , PaymentResultListener {

    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        val f = Home()
        supportFragmentManager.beginTransaction().add(R.id.fragment,f).commit()
    }

    override fun onPaymentSuccess(razorpayPaymentID: String?) {
        // store on server
        Toast.makeText(this, "Payment is successful : $razorpayPaymentID", Toast.LENGTH_SHORT).show();
    }

    override fun onPaymentError(p0: Int, s: String?) {
        Toast.makeText(this, "Payment Failed due to error : $s", Toast.LENGTH_SHORT).show();
    }
}