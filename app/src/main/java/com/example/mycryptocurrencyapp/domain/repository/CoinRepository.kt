package com.example.mycryptocurrencyapp.domain.repository

import com.example.mycryptocurrencyapp.data.dto.CoinDTO
import com.example.mycryptocurrencyapp.data.dto.CoinDetailsDTO

interface CoinRepository {

    suspend fun getAllCoins(): List<CoinDTO>

    suspend fun getCoinById(coinId: String): CoinDetailsDTO

}