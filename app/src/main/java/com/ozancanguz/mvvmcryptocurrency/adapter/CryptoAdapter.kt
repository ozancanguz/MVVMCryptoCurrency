package com.ozancanguz.mvvmcryptocurrency.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.mvvmcryptocurrency.R
import com.ozancanguz.mvvmcryptocurrency.model.Coin
import kotlinx.android.synthetic.main.item_layout.view.*

class CryptoAdapter(private val coinList:ArrayList<Coin>):RecyclerView.Adapter<CryptoAdapter.CoinViewHolder>(){


    fun updateCoinList(newCoinList: List<Coin>){

        coinList.clear()
        coinList.addAll(newCoinList)
        notifyDataSetChanged()
    }

    class CoinViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_layout,parent,false)
        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.itemView.currencytxt.text=coinList[position].currency
        holder.itemView.pricetxt.text=coinList[position].price
    }

    override fun getItemCount(): Int {
        return coinList.size
    }

}