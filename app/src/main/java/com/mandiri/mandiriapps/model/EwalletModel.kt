package com.mandiri.mandiriapps.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class EwalletModel(
    val name: String,
    val image: Int,
    val balance: Double,
    var isConnected: Boolean
) : Parcelable