package com.catstudio.foodlist.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by fxhp.
 * 2019
 * felixhudi.94@gmail.com
 */
@Parcelize
data class Food(
    val name : String,
    val image : String,
    val desc : String
) : Parcelable{

}