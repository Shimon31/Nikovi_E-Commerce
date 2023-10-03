package com.example.shimon.ecommerceapp.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.shimon.ecommerceapp.base.BaseFragment
import com.example.shimon.ecommerceapp.databinding.FragmentCartBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : BaseFragment<FragmentCartBinding>(FragmentCartBinding::inflate) {
    private val viewModel : CartViewModel by viewModels()

    private val adapter : cartAdapter by lazy {

        cartAdapter()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.allCartResponse.observe(viewLifecycleOwner){

        adapter.submitList(it[0].products)
            binding.cartRCV.adapter = adapter

        }
    }



}