package com.catstudio.foodlist

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.catstudio.foodlist.foodlist.ApiStatus
import com.catstudio.foodlist.foodlist.FoodsAdapter
import com.catstudio.foodlist.network.Food

/**
 * Created by fxhp.
 * 2019
 * felixhudi.94@gmail.com
 */
@BindingAdapter("listData")
fun bindRecyclerView(rv : RecyclerView, data : List<Food>?){
    val adapter = rv.adapter as FoodsAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImageUrl(imgView : ImageView, imgUrl : String){
    imgUrl?.let{
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()

        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: ApiStatus?) {
    when (status) {
        ApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        ApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        ApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}
