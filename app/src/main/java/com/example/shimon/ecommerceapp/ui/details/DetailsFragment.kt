package com.example.shimon.ecommerceapp.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import coil.load
import com.example.shimon.ecommerceapp.base.BaseFragment
import com.example.shimon.ecommerceapp.databinding.FragmentDetailsBinding
import com.example.shimon.ecommerceapp.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {

    private val viewModel: HomeViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.productResponse.observe(viewLifecycleOwner) {

            binding.apply {

                product1.load(it.image)
                brandName.text = it.title
                price.text = "$${it.price}"
                info.text = it.description
                Rating.text = "${it.rating?.rate}"
                totalRating.text = "(${it.rating?.count})"

            }
        }

    }


}