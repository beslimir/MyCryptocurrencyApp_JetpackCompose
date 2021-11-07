package com.example.mycryptocurrencyapp.domain.repository

import com.example.mycryptocurrencyapp.data.dto.CoinDTO
import com.example.mycryptocurrencyapp.data.dto.CoinDetailsDTO
import com.example.mycryptocurrencyapp.domain.model.Coin
import com.example.mycryptocurrencyapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    suspend fun getAllCoins(): List<CoinDTO>

    suspend fun getCoinById(coinId: String): CoinDetailsDTO

}