package com.mandiri.mandiriapps.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.model.HistoryTransactionModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryTransactionViewModel @Inject constructor() : ViewModel() {
    private val _historyTransactionData = MutableLiveData<List<HistoryTransactionModel>>()
    val historyTransactionData: LiveData<List<HistoryTransactionModel>>
        get() = _historyTransactionData
    fun setHistoryTransactionData() = viewModelScope.launch {
        _historyTransactionData.postValue(populateDataHistoryTransaction())
    }

    private fun populateDataHistoryTransaction(): List<HistoryTransactionModel> {
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
