package com.ozancanguz.mvvmcryptocurrency.Service

import com.ozancanguz.mvvmcryptocurrency.model.Coin
import io.reactivex.Single
import retrofit2.http.GET

interface CoinApi {


    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    fun getCoins(): Single<List<Coin>>

}