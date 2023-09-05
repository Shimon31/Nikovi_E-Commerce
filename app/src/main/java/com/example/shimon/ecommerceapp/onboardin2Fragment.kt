package com.example.shimon.ecommerceapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.shimon.ecommerceapp.databinding.FragmentOnboardin2Binding


class onboardin2Fragment : Fragment() {

    lateinit var binding:FragmentOnboardin2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentOnboardin2Binding.inflate(inflater)

        binding.nextBTN2.setOnClickListener {

            findNavController().navigate(R.id.action_onboardin2Fragment_to_onboarding3Fragment)

        }

        return binding.root
    }


}