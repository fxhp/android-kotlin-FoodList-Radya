package com.catstudio.foodlist.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.catstudio.foodlist.network.Food

/**
 * Created by fxhp.
 * 2019
 * felixhudi.94@gmail.com
 */

class DetailViewModelFactory(
    private val food: Food,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(food, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}