package com.washlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.washlist.Entity.AddressItem
import com.washlist.Entity.CartItem
import com.washlist.Entity.Item
import com.washlist.Entity.ItemSet
import kotlin.properties.Delegates

class MyViewModel : ViewModel() {
    var homeData = listOf(Item(ItemSet.SHIRT), Item(ItemSet.TSHIRT), Item(ItemSet.JEANS))
    val vendorData = listOf("A", "B", "C")
    var cartData =  mutableListOf<CartItem>()
    var selectedVendor by Delegates.notNull<Int>()
    lateinit var addressItem: AddressItem

    fun setCartData(){
        for(item in homeData){
            cartData.add(CartItem(item.itemName,item.qty, item.qty* getItemPrice(item.itemName)))
        }
    }

    private fun getItemPrice(itemSet: ItemSet): Float{
        return when(itemSet){
            ItemSet.SHIRT -> 5.00F
            ItemSet.JEANS -> 6.00F
            ItemSet.TSHIRT -> 7.00F
            else -> 0.00F
        }
    }

    fun getTotalAmount(): Int {
        var total = 0.0F
        for (item in cartData){
            total += item.price
        }
        return total.toInt()
    }
}