package com.example.shimon.ecommerceapp.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shimon.ecommerceapp.data.cart.Product
import com.example.shimon.ecommerceapp.data.cart.ResponseCartItem
import com.example.shimon.ecommerceapp.databinding.CartItemBinding

class cartAdapter : ListAdapter<Product, cartAdapter.VH>(COMPARATOR) {

    class VH(val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root) {


    }

    companion object {

        val COMPARATOR = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(
                oldItem: Product,
                newItem: Product
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: Product,
                newItem: Product
            ): Boolean {
                return oldItem.productId == newItem.productId
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        getItem(position).let{cart->

            holder.binding.apply {

                this.productId.text = "${cart?.productId}"
                this.productQuantity.text = "${cart?.quantity}"

            }

        }
    }

}