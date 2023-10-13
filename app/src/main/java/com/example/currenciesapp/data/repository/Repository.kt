package com.example.currenciesapp.data.repository

import com.example.currenciesapp.data.api.RetrofitInstance
import com.example.currenciesapp.model.Valute
import com.example.currenciesapp.model.ValuteResponse
import retrofit2.Call

import retrofit2.Response

class Repository {

    suspend fun getVal(date: String): Response<ValuteResponse> {
        return RetrofitInstance.api.getValute(date)
    }

}