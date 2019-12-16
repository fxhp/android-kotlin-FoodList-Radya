package com.catstudio.foodlist.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/**
 * Created by fxhp.
 * 2019
 * felixhudi.94@gmail.com
 */

private const val BASE_URL = " http://45.76.14.6:7000/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface NetworkApi {
    @GET("foods")
    fun getFoods():
            Deferred<List<Food>>
}

object FoodsApi {
    val retrofitService : NetworkApi by lazy { retrofit.create(NetworkApi::class.java) }
}