package com.example.mycryptocurrencyapp.data.api

import com.example.mycryptocurrencyapp.data.dto.CoinDTO
import com.example.mycryptocurrencyapp.data.dto.CoinDetailsDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaAPI {

    @GET("/v1/coins")
    suspend fun getAllCoins(): List<CoinDTO>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailsDTO
}