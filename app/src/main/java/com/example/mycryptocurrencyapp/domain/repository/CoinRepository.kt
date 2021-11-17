package com.example.mycryptocurrencyapp.domain.repository

import com.example.mycryptocurrencyapp.data.dto.CoinDTO
import com.example.mycryptocurrencyapp.data.dto.CoinDetailsDTO
import com.example.mycryptocurrencyapp.data.model.Coin
import com.example.mycryptocurrencyapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    fun getAllCoins(): Flow<Resource<List<Coin>>>

    suspend fun getCoinById(coinId: String): CoinDetailsDTO

}