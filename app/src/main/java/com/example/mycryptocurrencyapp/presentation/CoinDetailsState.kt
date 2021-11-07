package com.example.mycryptocurrencyapp.presentation

import com.example.mycryptocurrencyapp.domain.model.Coin
import com.example.mycryptocurrencyapp.domain.model.CoinDetails

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coin: CoinDetails? = null,
    val error: String = ""
)