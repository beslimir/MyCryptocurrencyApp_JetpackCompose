package com.example.mycryptocurrencyapp.data.repository

import com.example.mycryptocurrencyapp.data.api.CoinPaprikaAPI
import com.example.mycryptocurrencyapp.data.dto.CoinDTO
import com.example.mycryptocurrencyapp.data.dto.toCoin
import com.example.mycryptocurrencyapp.data.model.Coin
import com.example.mycryptocurrencyapp.domain.repository.CoinRepository
import com.example.mycryptocurrencyapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaAPI
) : CoinRepository {

    override fun getAllCoins(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = api.getAllCoins()
            emit(Resource.Success<List<Coin>>(coins))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection."))
        }
    }

    override suspend fun getCoinById(coinId: String) = api.getCoinById(coinId)
}