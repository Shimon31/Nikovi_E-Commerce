package com.example.shimon.ecommerceapp.di

import com.example.shimon.ecommerceapp.api.ProductService
import com.example.shimon.ecommerceapp.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {


    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit.Builder {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

    }

    @Singleton
    @Provides
    fun provideProductService(retrofit: Retrofit.Builder): ProductService {
        return retrofit.build().create(ProductService::class.java)

    }


}