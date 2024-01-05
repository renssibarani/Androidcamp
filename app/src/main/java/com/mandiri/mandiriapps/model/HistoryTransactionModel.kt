package com.mandiri.mandiriapps.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HistoryTransactionModel(
    val date: String,
    val titleTrasaction: String,
    val balanceTrasaction: String,
    val iconTransaction: Int,
    val subtitleTrasaction: String,
    val statusTransaction: Int
): Parcelable

enum class statusTransaction(val value: Int){
    Berhasil(1),
    Gagal(2),
    Pending(3)
}

enum class StatusTransfer(val value: String){
    Credit("Credit"),
    Debit("Debit")
}
