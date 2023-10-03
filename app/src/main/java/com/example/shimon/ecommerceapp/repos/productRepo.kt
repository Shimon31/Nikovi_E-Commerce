package com.example.shimon.ecommerceapp.repos

import com.example.shimon.ecommerceapp.api.ProductService
import com.example.shimon.ecommerceapp.data.cart.ResponseCart
import com.example.shimon.ecommerceapp.data.cart.ResponseCartItem
import com.example.shimon.ecommerceapp.data.product.ResponseProduct
import retrofit2.Response
import javax.inject.Inject

class productRepo @Inject constructor(private val service: ProductService) {

    suspend fun getAllProducts():Response<List<ResponseProduct>>{
        return service.getAllProduct()
    }

    suspend fun getProductById(id:Int):Response<ResponseProduct>{
        return service.getProductById(id)

    }

    suspend fun getAllCart():Response<List<ResponseCartItem>>{
        return service.getAllCart(1)
    }

}