package com.example.shimon.ecommerceapp.api

import com.example.shimon.ecommerceapp.data.cart.ResponseCart
import com.example.shimon.ecommerceapp.data.cart.ResponseCartItem
import com.example.shimon.ecommerceapp.data.product.ResponseProduct
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("products")
    suspend fun getAllProduct(): Response<List<ResponseProduct>>

    @GET("products/{id}")
    suspend fun getProductById(
        @Path("id") id : Int
    ): Response<ResponseProduct>

    @GET("carts/user/{id}")
    suspend fun getAllCart(@Path("id") id:Int): Response<List<ResponseCartItem>>
}