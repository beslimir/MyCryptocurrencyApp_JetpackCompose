package com.example.mycryptocurrencyapp.presentation.coin_list

import com.example.mycryptocurrencyapp.data.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)