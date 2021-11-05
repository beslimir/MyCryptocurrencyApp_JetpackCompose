package com.example.mycryptocurrencyapp.domain.use_case

import com.example.mycryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {

    suspend operator fun invoke(coinId: String) = coinRepository.getCoinById(coinId)

}