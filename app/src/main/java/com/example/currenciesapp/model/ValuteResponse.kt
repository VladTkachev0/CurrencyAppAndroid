package com.example.currenciesapp.model

import com.google.gson.annotations.SerializedName

data class ValuteResponse (
    @SerializedName("Date")
    val date: String,

    @SerializedName("PreviousDate")
    val previousDate: String,

    @SerializedName("PreviousURL")
    val previousURL: String,

    @SerializedName("Timestamp")
    val timestamp: String,

    @SerializedName("Valute")
    val valute: Map<String, Valute>
)