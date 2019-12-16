package com.catstudio.foodlist.foodlist

import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.catstudio.foodlist.databinding.GridViewItemBinding
import com.catstudio.foodlist.network.Food

/**
 * Created by fxhp.
 * 2019
 * felixhudi.94@gmail.com
 */

class FoodsAdapter( private val onClick : OnClickListener ) :
    ListAdapter<Food, FoodsAdapter.FoodViewHolder>(DiffCallback){

    class FoodViewHolder(private var binding : GridViewItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(food: Food){
            binding.food = food
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Food>() {
        override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem.name == newItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): FoodViewHolder {
        return FoodViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = getItem(position)
        holder.itemView.setOnClickListener {
            onClick.onClick(food)
        }
        holder.bind(food)
    }

    class OnClickListener(val clickListener: (food:Food) -> Unit) {
        fun onClick(food:Food) = clickListener(food)
    }

}