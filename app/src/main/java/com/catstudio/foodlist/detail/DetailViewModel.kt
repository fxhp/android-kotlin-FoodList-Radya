package com.catstudio.foodlist.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.catstudio.foodlist.network.Food

/**
 * Created by fxhp.
 * 2019
 * felixhudi.94@gmail.com
 */

class DetailViewModel ( food : Food, app : Application): AndroidViewModel(app){

    private val _selectedFood = MutableLiveData<Food>()

    val selectedFood : LiveData<Food>
        get() = _selectedFood

    init {
        _selectedFood.value = food
    }

}