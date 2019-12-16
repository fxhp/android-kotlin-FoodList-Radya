package com.catstudio.foodlist.detail

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.catstudio.foodlist.R
import com.catstudio.foodlist.databinding.FragmentDetailBinding

/**
 * Created by fxhp.
 * 2019
 * felixhudi.94@gmail.com
 */

class DetailFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(activity).application
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.setLifecycleOwner(this)

        val food = DetailFragmentArgs.fromBundle(arguments!!).selectedFood
        val viewModelFactory = DetailViewModelFactory(food, application)
        binding.viewModel = ViewModelProviders.of(
            this, viewModelFactory).get(DetailViewModel::class.java)

        return binding.root
    }
}