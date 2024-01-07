package com.mandiri.mandiriapps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.mandiriapps.databinding.ItemSavingDepositBinding
import com.mandiri.mandiriapps.model.SavingDepositModel

class SavingDepositAdapter(
    private val savingDepositData: MutableList<SavingDepositModel>
) : RecyclerView.Adapter<SavingDepositAdapter.SavingDepositViewHolder>() {
    private var maximumItems = 2

    inner class SavingDepositViewHolder(private val itemBinding: ItemSavingDepositBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: SavingDepositModel) {
            itemBinding.tvSavingDepositName.text = data.savingName
            itemBinding.ivCardHolder.setImageResource(data.imageCard)
            itemBinding.tvAccountNumber.text = data.accountNumber
            itemBinding.tvBalanceSavingDeposit.text = data.balaceCard
        }

        fun setBalanceVisibility(isVisible: Boolean) {
            itemBinding.tvBalanceSavingDeposit.visibility =
                if (isVisible) View.VISIBLE else View.GONE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavingDepositViewHolder {
        return SavingDepositViewHolder(
            ItemSavingDepositBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int =
        if (savingDepositData.size >= 2) maximumItems else savingDepositData.size

    override fun onBindViewHolder(holder: SavingDepositViewHolder, position: Int) {
        holder.bind(savingDepositData[position])
    }

    fun updateQuantityDepositSize(sizeUpdated: Int) {
        maximumItems = sizeUpdated
        notifyDataSetChanged()
    }
}