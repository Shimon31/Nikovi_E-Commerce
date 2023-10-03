package com.example.shimon.ecommerceapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shimon.ecommerceapp.data.product.ResponseProduct
import com.example.shimon.ecommerceapp.repos.productRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: productRepo) : ViewModel() {

    private val _allProductResponse = MutableLiveData<List<ResponseProduct>>()

    val allProductResponse: LiveData<List<ResponseProduct>>
        get() = _allProductResponse

    init {
        getAllProduct()
    }

    private fun getAllProduct() {

        viewModelScope.launch {

            val response = repo.getAllProducts()

            if (response.isSuccessful) {
                _allProductResponse.postValue(response.body())

            }

        }

    }

    private val _productResponse = MutableLiveData<ResponseProduct>()

    val productResponse: LiveData<ResponseProduct>
        get() = _productResponse




    fun getProductById(id:Int){
        viewModelScope.launch {

            val response = repo.getProductById(id)
            if (response.isSuccessful){
                _productResponse.postValue(response.body())

            }
        }


    }

}