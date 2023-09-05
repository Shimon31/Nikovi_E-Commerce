package com.example.shimon.ecommerceapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.shimon.ecommerceapp.databinding.FragmentOnboarding1Binding


class Onboarding1Fragment : Fragment() {
    lateinit var binding:FragmentOnboarding1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboarding1Binding.inflate(inflater)

        binding.nextBTN1.setOnClickListener {

            findNavController().navigate(R.id.action_onboarding1Fragment_to_onboardin2Fragment)

        }


        return binding.root
    }


}