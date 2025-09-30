package com.example.ifunsoedmobile.data.network

import com.example.ifunsoedmobile.data.model.SearchResponse
import retrofit2.Response // Import Response
import retrofit2.http.GET // Import GET
import retrofit2.http.Query // Import Query

interface OpenLibraryApi {

    @GET("search.json")
    suspend fun searchBooks(
        @Query("q") query: String,
        @Query("limit") limit: Int
    ): Response<SearchResponse>
}