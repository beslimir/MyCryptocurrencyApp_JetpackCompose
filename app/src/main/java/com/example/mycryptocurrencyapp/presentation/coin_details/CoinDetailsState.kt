package com.example.mycryptocurrencyapp.presentation.coin_details

import com.example.mycryptocurrencyapp.data.model.CoinDetails

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coin: CoinDetails? = null,
    val error: String = ""
)