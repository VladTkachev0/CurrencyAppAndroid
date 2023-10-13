package com.example.currenciesapp.model

import java.io.Serializable

data class Valute(
    val CharCode: String,
    val ID: String,
    val Name: String,
    val Nominal: Int,
    val NumCode: String,
    val Previous: Double,
    val Value: Double
): Serializable