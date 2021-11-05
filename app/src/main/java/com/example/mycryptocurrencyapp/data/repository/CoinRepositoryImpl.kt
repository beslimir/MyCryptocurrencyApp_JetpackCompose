package com.example.mycryptocurrencyapp.data.repository

import com.example.mycryptocurrencyapp.data.api.CoinPaprikaAPI
import com.example.mycryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaAPI
) : CoinRepository {

    override suspend fun getAllCoins() = api.getAllCoins()

    override suspend fun getCoinById(coinId: String) = api.getCoinById(coinId)
}