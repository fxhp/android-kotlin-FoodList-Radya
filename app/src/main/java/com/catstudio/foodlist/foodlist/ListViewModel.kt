package com.catstudio.foodlist.foodlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.catstudio.foodlist.network.Food
import com.catstudio.foodlist.network.FoodsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * Created by fxhp.
 * 2019
 * felixhudi.94@gmail.com
 */

enum class ApiStatus { LOADING, ERROR, DONE }

class FoodListViewModel : ViewModel() {

    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus>
        get() = _status

    private val _foods = MutableLiveData<List<Food>>()
    val foods: LiveData<List<Food>>
        get() = _foods

    private val _navigateToSelected = MutableLiveData<Food>()
    val navigateToSelected: LiveData<Food>
        get() = _navigateToSelected

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getFoods()
    }

    private fun getFoods() {
        coroutineScope.launch {
            var getFoodDeferred = FoodsApi.retrofitService.getFoods()
            try {
                _status.value = ApiStatus.LOADING
                val listResult = getFoodDeferred.await()
                _status.value = ApiStatus.DONE
                _foods.value = listResult
            } catch (e: Exception) {
                Log.e("apiCall","${e.message}")
                _status.value = ApiStatus.ERROR
                _foods.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun showDetails(food : Food) {
        _navigateToSelected.value = food
    }

    fun showDetailsComplete() {
        _navigateToSelected.value = null
    }


}