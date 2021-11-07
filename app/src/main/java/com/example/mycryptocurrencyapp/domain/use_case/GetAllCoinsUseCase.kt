package com.example.mycryptocurrencyapp.domain.use_case

import com.example.mycryptocurrencyapp.data.dto.toCoin
import com.example.mycryptocurrencyapp.domain.model.Coin
import com.example.mycryptocurrencyapp.domain.repository.CoinRepository
import com.example.mycryptocurrencyapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllCoinsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = coinRepository.getAllCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection."))
        }
    }

}