package com.mandiri.mandiriapps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.mandiriapps.databinding.ItemEwalletBinding
import com.mandiri.mandiriapps.model.EwalletModel

class EwalletAdapter : RecyclerView.Adapter<EwalletAdapter.ViewHolder>() {

    private var listEwallet: MutableList<EwalletModel> = mutableListOf()

    private var _onClickEwallet: (EwalletModel) -> Unit = {}
    fun setDataEwallet(data: MutableList<EwalletModel>) {
        this.listEwallet = data
        notifyDataSetChanged()
    }

    fun setOnClickEwallet(listener: (EwalletModel) -> Unit) {
        _onClickEwallet = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemEwalletBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = listEwallet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listEwallet[position], _onClickEwallet)
    }

    inner class ViewHolder(private val itemBinding: ItemEwalletBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(ewallet: EwalletModel, onClickEwallet: (EwalletModel) -> Unit) {

            if (ewallet.isConnected) {
                itemBinding.tvBalance.visibility = View.VISIBLE
                itemBinding.vConnectAccount.visibility = View.GONE
            } else {
                itemBinding.tvBalance.visibility = View.GONE
                itemBinding.vConnectAccount.visibility = View.VISIBLE
            }

            itemBinding.tvBalance.text = ewallet.balance.toString()
            itemBinding.ivImage.setImageResource(ewallet.image)
            itemBinding.vConnectAccount.setOnClickListener { onClickEwallet.invoke(ewallet) }
        }
    }
}