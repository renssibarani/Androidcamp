package com.mandiri.mandiriapps.presentation.message.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.adapter.HistoryTransactionAdapter
import com.mandiri.mandiriapps.databinding.FragmentHistoryTrasactionBinding
import com.mandiri.mandiriapps.databinding.FragmentNotificationBinding
import com.mandiri.mandiriapps.model.HistoryTransactionModel

class HistoryTransactionFragment : Fragment() {
    private var _binding : FragmentHistoryTrasactionBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryTrasactionBinding.inflate(inflater, container, false)
        setupViewHistoryTransaction()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun setupViewHistoryTransaction(){
        binding.rvTransaction.adapter = HistoryTransactionAdapter(
            listTransaction = populateDataHistoryTransaction(),
            onClickHistoryTransaction = {
                navigateToDetailHistory()
            }
        )
    }
    private fun navigateToDetailHistory(){
        val intent = Intent(context, DetailTransactionActivity::class.java)
        startActivity(intent)
    }
    private fun populateDataHistoryTransaction(): List<HistoryTransactionModel>{
       return listOf(
           HistoryTransactionModel(
               date = "24 Januari 2024",
               titleTrasaction = "Debit",
               subtitleTrasaction = "Transfer Mandiri -Tiara",
               balanceTrasaction = "Rp 200.000",
               iconTransaction = R.drawable.ic_in_transaction,
               statusTransaction = 1
           ),
           HistoryTransactionModel(
               date = "24 Januari 2024",
               titleTrasaction = "Credit",
               subtitleTrasaction = "Transfer Mandiri -Rens",
               balanceTrasaction = "Rp 100.000",
               iconTransaction = R.drawable.ic_in_transaction,
               statusTransaction = 3
           ),
           HistoryTransactionModel(
               date = "24 Januari 2024",
               titleTrasaction = "Debit",
               subtitleTrasaction = "Transfer Mandiri -Tiara",
               balanceTrasaction = "Rp 200.000",
               iconTransaction = R.drawable.ic_in_transaction,
               statusTransaction = 2
           ),
           HistoryTransactionModel(
               date = "24 Januari 2024",
               titleTrasaction = "Credit",
               subtitleTrasaction = "Transfer Mandiri -Rens",
               balanceTrasaction = "Rp 100.000",
               iconTransaction = R.drawable.ic_in_transaction,
               statusTransaction = 1
           ),
           HistoryTransactionModel(
               date = "24 Januari 2024",
               titleTrasaction = "Debit",
               subtitleTrasaction = "Transfer Mandiri -Tiara",
               balanceTrasaction = "Rp 200.000",
               iconTransaction = R.drawable.ic_in_transaction,
               statusTransaction = 2
           ),
           HistoryTransactionModel(
               date = "24 Januari 2024",
               titleTrasaction = "Credit",
               subtitleTrasaction = "Transfer Mandiri -Rens",
               balanceTrasaction = "Rp 100.000",
               iconTransaction = R.drawable.ic_in_transaction,
               statusTransaction = 3
           )
       )
    }
}