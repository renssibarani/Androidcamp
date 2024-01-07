package com.mandiri.mandiriapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.mandiriapps.databinding.ComponentCardItemBinding
import com.mandiri.mandiriapps.databinding.ItemCardCreditBinding
import com.mandiri.mandiriapps.databinding.ItemSavingDepositBinding
import com.mandiri.mandiriapps.model.CreditCardModel

class CredirCardAdapter(
    private val listCreditCard : List<CreditCardModel>
) : RecyclerView.Adapter<CredirCardAdapter.CreditCardViewHolder>(){
    inner class CreditCardViewHolder(private val itemBinding: ItemCardCreditBinding):
    RecyclerView.ViewHolder(itemBinding.root){
        fun bind(data: CreditCardModel){
            itemBinding.tvCreditTitle.text = data.creditCardName
            itemBinding.ivCardHolder.setImageResource(data.imageCard)
            itemBinding.tvCreditNumber.text = data.accountCreditNumber
            itemBinding.tvBalanceCredit.text = data.balanceCard
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreditCardViewHolder {
        return CreditCardViewHolder(
            ItemCardCreditBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listCreditCard.size
    }

    override fun onBindViewHolder(holder: CreditCardViewHolder, position: Int) {
        holder.bind(listCreditCard[position])
    }


}