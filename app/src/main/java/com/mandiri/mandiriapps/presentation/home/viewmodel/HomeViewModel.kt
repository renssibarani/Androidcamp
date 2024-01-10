package com.mandiri.mandiriapps.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.model.CreditCardModel
import com.mandiri.mandiriapps.model.EwalletModel
import com.mandiri.mandiriapps.model.MenuModel
import com.mandiri.mandiriapps.model.SavingDepositModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _ewalletData = MutableLiveData<MutableList<EwalletModel>>()
    val ewalletData: LiveData<MutableList<EwalletModel>>
        get() = _ewalletData

    private val _savingDepositData = MutableLiveData<MutableList<SavingDepositModel>>()
    val savingDepositData: LiveData<MutableList<SavingDepositModel>>
        get() = _savingDepositData

    private val _creditCardData = MutableLiveData<List<CreditCardModel>>()
    val creditCardData: LiveData<List<CreditCardModel>>
        get() = _creditCardData

    private val _menuHomeData = MutableLiveData<List<MenuModel>>()
    val menuHomeData: LiveData<List<MenuModel>>
        get() = _menuHomeData
    fun setEwalletData() = viewModelScope.launch {
        _ewalletData.postValue(populateDataEwallet())
    }

    fun setSavingDepositData() = viewModelScope.launch {
        _savingDepositData.postValue(populateSavingDepositData())
    }

    fun setCreditCardData() = viewModelScope.launch {
        _creditCardData.postValue(populateCreditCard())
    }

    fun setMenuHomeData() = viewModelScope.launch {
        _menuHomeData.postValue(populateDataMenuHome())
    }


    private fun populateDataEwallet(): MutableList<EwalletModel> {
        return mutableListOf(
            EwalletModel(
                name = "Gopay", image = R.drawable.ic_gopay, balance = 100000.0, isConnected = true
            ), EwalletModel(
                name = "Shopee",
                image = R.drawable.ic_barcode,
                balance = 100000.0,
                isConnected = false
            ), EwalletModel(
                name = "LinkAja",
                image = R.drawable.ic_linkaja,
                balance = 100000.0,
                isConnected = false
            ), EwalletModel(
                name = "Ovo", image = R.drawable.ic_ovo, balance = 100000.0, isConnected = false
            ), EwalletModel(
                name = "Dana", image = R.drawable.ic_dana, balance = 100000.0, isConnected = false
            ), EwalletModel(
                name = "AstraPay",
                image = R.drawable.ic_barcode,
                balance = 100000.0,
                isConnected = false
            )
        )
    }

    private fun populateSavingDepositData(): MutableList<SavingDepositModel> {
        return mutableListOf(
            SavingDepositModel(
                savingName = "Tabungan IDR NOW",
                accountNumber = "17432748372478",
                imageCard = R.drawable.ic_gold_card,
                balaceCard = "Rp 5.000.000.00"
            ),
            SavingDepositModel(
                savingName = "Tabungan Visa Gold",
                accountNumber = "17432743785632",
                imageCard = R.drawable.ic_gold_visa,
                balaceCard = "Rp 4.000.000.00"
            ),
            SavingDepositModel(
                savingName = "Tabungan Silver GPN",
                accountNumber = "17432748373245",
                imageCard = R.drawable.ic_silver_card,
                balaceCard = "Rp 6.000.000.00"
            ),
            SavingDepositModel(
                savingName = "Tabungan Gold GPN",
                accountNumber = "17432748372389",
                imageCard = R.drawable.ic_gold_card,
                balaceCard = "Rp 7.000.000.00"
            ),
        )
    }

    private fun populateCreditCard(): List<CreditCardModel> {
        return listOf(
            CreditCardModel(
                creditCardName = "Mandiri SKYZ",
                accountCreditNumber = "23445653434223",
                imageCard = R.drawable.ic_credit_skyz,
                balanceCard = "Rp 4.500.000.00"
            ),
            CreditCardModel(
                creditCardName = "Mandiri CORPORATE",
                accountCreditNumber = "23445653434223",
                imageCard = R.drawable.ic_credit_corporate,
                balanceCard = "Rp 50.000.000.00"
            ),
            CreditCardModel(
                creditCardName = "Mandiri PRIORITAS",
                accountCreditNumber = "23445653434223",
                imageCard = R.drawable.ic_credit_priority,
                balanceCard = "Rp 100.000.000.00"
            ),
        )
    }

    private fun populateDataMenuHome(): List<MenuModel> {
        return listOf(
            MenuModel(
                image = R.drawable.ic_transfer, menuTitle = "Transfer"
            ), MenuModel(
                image = R.drawable.ic_zakat, menuTitle = "Donasi"
            ), MenuModel(
                image = R.drawable.ic_qr, menuTitle = "QR"
            ), MenuModel(
                image = R.drawable.ic_zakat, menuTitle = "Zakat"
            ), MenuModel(
                image = R.drawable.ic_barcode_scan, menuTitle = "Cashsles"
            ), MenuModel(
                image = R.drawable.ic_ewallet, menuTitle = "E-Wallet"
            ), MenuModel(
                image = R.drawable.ic_tarik, menuTitle = "Tarik"
            ), MenuModel(
                image = R.drawable.ic_zakat, menuTitle = "Bayar"
            ), MenuModel(
                image = R.drawable.ic_setor, menuTitle = "Setor"
            )
        )
    }


}