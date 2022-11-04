package com.ozancanguz.mvvmcryptocurrency.Service

import com.ozancanguz.mvvmcryptocurrency.model.Coin
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CoinService{

    private val BASE_URL="https://raw.githubusercontent.com"

      private var api=Retrofit.Builder()
           .baseUrl(BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
           .build()
           .create(CoinApi::class.java)

       fun getData(): Single<List<Coin>> {
           return api.getCoins()
       }
}