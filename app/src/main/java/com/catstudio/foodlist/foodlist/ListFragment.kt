package com.catstudio.foodlist.foodlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.catstudio.foodlist.databinding.FragmentListBinding

/**
 * Created by fxhp.
 * 2019
 * felixhudi.94@gmail.com
 */

class ListFragment : Fragment() {

    private val viewModel: FoodListViewModel by lazy {
        ViewModelProviders.of(this).get(FoodListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentListBinding.inflate(inflater)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
        binding.rvFoods.adapter = FoodsAdapter(FoodsAdapter.OnClickListener {
            viewModel.showDetails(it)
        })

        viewModel.navigateToSelected.observe(this, Observer {
            if ( null != it){
                this.findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(it))
                viewModel.showDetailsComplete()
            }
        })

        return binding.root
    }
}