package com.example.currenciesapp.data.api


import com.example.currenciesapp.model.ValuteResponse

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("archive/{date}.js")
    suspend fun getValute(@Path("date") date: String): Response<ValuteResponse>
}


