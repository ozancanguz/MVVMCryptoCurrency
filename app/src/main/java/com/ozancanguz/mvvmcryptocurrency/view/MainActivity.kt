package com.ozancanguz.mvvmcryptocurrency.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozancanguz.mvvmcryptocurrency.R
import com.ozancanguz.mvvmcryptocurrency.adapter.CryptoAdapter
import com.ozancanguz.mvvmcryptocurrency.viewmodel.CoinViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //1
    private lateinit var viewmodel:CoinViewModel
    var cryptoAdapter=CryptoAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //2
        viewmodel=ViewModelProvider(this).get(CoinViewModel::class.java)
        viewmodel.refresh()

        //3
        recyclerView2.layoutManager=LinearLayoutManager(this@MainActivity)
        recyclerView2.adapter=cryptoAdapter

        // 4
        observeViewModel()




    }

    private fun observeViewModel() {

        viewmodel.coins.observe(this, Observer { coinList ->

            coinList.let{
                cryptoAdapter.updateCoinList(coinList)
            }


        })

    }
}