package com.mandiri.mandiriapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.databinding.ItemHistoryTransactionBinding
import com.mandiri.mandiriapps.databinding.ItemNotificationBinding
import com.mandiri.mandiriapps.model.HistoryTransactionModel
import com.mandiri.mandiriapps.model.StatusTransfer
import com.mandiri.mandiriapps.model.statusTransaction

class HistoryTransactionAdapter(
    private val listTransaction: List<HistoryTransactionModel>,
    private val onClickHistoryTransaction: (HistoryTransactionModel)-> Unit
): RecyclerView.Adapter<HistoryTransactionAdapter.TransactionHistoryViewHolder>() {
inner class TransactionHistoryViewHolder(val binding: ItemHistoryTransactionBinding) :
    RecyclerView.ViewHolder(binding.root){
        fun bind(data: HistoryTransactionModel){
            binding.tvDateTransaction.text = data.date
            binding.tvTitleTransaction.text = data.titleTrasaction
            binding.tvSubtitleTransaction.text = data.subtitleTrasaction
//            binding.ivLogoTrasaction.setImageResource(data.iconTransaction)
            when(data.titleTrasaction){
                StatusTransfer.Debit.value->{
                    binding.ivLogoTrasaction.setImageResource(R.drawable.ic_in_transaction)
                }
                StatusTransfer.Credit.value->{
                    binding.ivLogoTrasaction.setImageResource(R.drawable.ic_out)
                }
            }
            binding.tvBalanceTrsaction.text = data.balanceTrasaction
            when(data.statusTransaction){
                statusTransaction.Berhasil.value-> {
                    binding.statusTransaction.text = "Berhasil"
                }
                statusTransaction.Gagal.value->{
                    binding.statusTransaction.text = "Gagal"
                    binding.statusTransaction.setTextColor(binding.root.context.getColor(R.color.red))
                }
                statusTransaction.Pending.value->{
                    binding.statusTransaction.text = "Pending"
                    binding.statusTransaction.setTextColor(binding.root.context.getColor(R.color.blue))

                }
            }
            binding.constraintItemTransaction.setOnClickListener{
                onClickHistoryTransaction.invoke(data)
            }
        }

}

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TransactionHistoryViewHolder {
        return TransactionHistoryViewHolder(
            ItemHistoryTransactionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = listTransaction.size

    override fun onBindViewHolder(holder: TransactionHistoryViewHolder, position: Int) {
        holder.bind(listTransaction[position])
    }
}
