package com.example.chapter6_topic5.network

import com.example.chapter6_topic5.model.ResponseDataMakeupItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/v1/products.json")
    fun getAllMakeup(): Call<List<ResponseDataMakeupItem>>
}