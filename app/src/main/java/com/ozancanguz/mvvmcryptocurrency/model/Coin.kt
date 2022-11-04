package com.ozancanguz.mvvmcryptocurrency.model


import com.google.gson.annotations.SerializedName

data class Coin(
    @SerializedName("currency")
    val currency: String,
    @SerializedName("price")
    val price: String
)