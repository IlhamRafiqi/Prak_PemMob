package com.example.ifunsoedmobile.data.network

import com.example.ifunsoedmobile.utils.Constans
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: OpenLibraryApi by lazy {
        Retrofit.Builder()
            .baseUrl( Constans.BASE_URL)
            .addConverterFactory( GsonConverterFactory.create())
            .build()
            .create(OpenLibraryApi::class.java)
    }
}