package com.ozancanguz.mvvmcryptocurrency.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ozancanguz.mvvmcryptocurrency.Service.CoinService
import com.ozancanguz.mvvmcryptocurrency.model.Coin
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CoinViewModel:ViewModel() {


    private val disposable= CompositeDisposable()
    private val coinservice=CoinService()

    var coins=MutableLiveData<List<Coin>>()

    fun refresh(){
        fetchFromRemote()
    }


   fun fetchFromRemote(){
           disposable.add(
               coinservice.getData()
                   .subscribeOn(Schedulers.newThread())
                   .observeOn(AndroidSchedulers.mainThread())
                   .subscribeWith(object :DisposableSingleObserver<List<Coin>>(){
                       override fun onSuccess(coinList: List<Coin>?) {
                        coins.value=coinList!!

                       }

                       override fun onError(e: Throwable?) {
                          Log.d("error","veri cekilemedi")
                       }


                   })

           )

   }

}