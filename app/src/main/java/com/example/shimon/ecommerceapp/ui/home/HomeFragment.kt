package com.example.shimon.ecommerceapp.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.shimon.ecommerceapp.R
import com.example.shimon.ecommerceapp.base.BaseFragment
import com.example.shimon.ecommerceapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate),HomeAdapter.Listener {


    private val viewModel:HomeViewModel by activityViewModels()
    private val adapter:HomeAdapter by lazy {

        HomeAdapter(this@HomeFragment)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.allProductResponse.observe(viewLifecycleOwner){

            adapter.submitList(it)
            binding.recyclerView1.adapter = adapter

        }

    }

    override fun itemClick(id: Int) {
        viewModel.getProductById(1)
        findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)

    }

}