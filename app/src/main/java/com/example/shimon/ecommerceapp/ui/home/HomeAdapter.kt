package com.example.shimon.ecommerceapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.shimon.ecommerceapp.data.product.ResponseProduct
import com.example.shimon.ecommerceapp.databinding.Products1Binding

class HomeAdapter(private val listener:Listener) : ListAdapter<ResponseProduct, HomeAdapter.VH>(COMPARATOR) {


    interface Listener {

        fun itemClick(id: Int)

    }

    class VH(val binding: Products1Binding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(Products1Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        getItem(position).let {

            holder.binding.apply {

                product1.load(it.image)
                brandName.text = it.title
                price.text = "$${it.price}"
                info.text = it.description
                Rating.text = "${it.rating?.rate}"
                totalRating.text = "(${it.rating?.count})"

                holder.itemView.setOnClickListener {

                    listener.itemClick(it.id)

                }


            }

        }
    }

    companion object {

        var COMPARATOR = object : DiffUtil.ItemCallback<ResponseProduct>() {
            override fun areItemsTheSame(
                oldItem: ResponseProduct,
                newItem: ResponseProduct
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ResponseProduct,
                newItem: ResponseProduct
            ): Boolean {
                return oldItem.id == newItem.id
            }

        }

    }

}