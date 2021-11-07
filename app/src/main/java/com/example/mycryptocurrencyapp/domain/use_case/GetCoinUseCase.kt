package com.example.mycryptocurrencyapp.domain.use_case

import com.example.mycryptocurrencyapp.data.dto.toCoinDetails
import com.example.mycryptocurrencyapp.domain.model.CoinDetails
import com.example.mycryptocurrencyapp.domain.repository.CoinRepository
import com.example.mycryptocurrencyapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading<CoinDetails>())
            val coin = coinRepository.getCoinById(coinId).toCoinDetails()
            emit(Resource.Success<CoinDetails>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetails>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetails>("Couldn't reach server. Check your internet connection."))
        }
    }

}