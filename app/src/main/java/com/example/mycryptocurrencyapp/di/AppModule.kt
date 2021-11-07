package com.example.mycryptocurrencyapp.di

import com.example.mycryptocurrencyapp.data.api.CoinPaprikaAPI
import com.example.mycryptocurrencyapp.data.repository.CoinRepositoryImpl
import com.example.mycryptocurrencyapp.domain.repository.CoinRepository
import com.example.mycryptocurrencyapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(): CoinPaprikaAPI = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CoinPaprikaAPI::class.java)

    @Singleton
    @Provides
    fun provideCoinRepository(api: CoinPaprikaAPI): CoinRepository = CoinRepositoryImpl(api)

}