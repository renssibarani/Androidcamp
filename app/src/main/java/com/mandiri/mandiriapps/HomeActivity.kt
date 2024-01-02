package com.mandiri.mandiriapps

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuAdapter
import androidx.core.view.isVisible
import com.mandiri.mandiriapps.adapter.EwalletAdapter
import com.mandiri.mandiriapps.adapter.MenuHomeAdapter
import com.mandiri.mandiriapps.adapter.SavingDepositAdapter
import com.mandiri.mandiriapps.databinding.ActivityHomeBinding
import com.mandiri.mandiriapps.databinding.ItemEwalletBinding
import com.mandiri.mandiriapps.helper.SharedPref
import com.mandiri.mandiriapps.model.EwalletModel
import com.mandiri.mandiriapps.model.MenuModel
import com.mandiri.mandiriapps.model.SavingDepositModel

class HomeActivity: AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private var ewalletAdapter = EwalletAdapter()
    private var dummyEwalletList: MutableList<EwalletModel>? = null
    private lateinit var savingDepositAdapter: SavingDepositAdapter
    private lateinit var menuAdapter: MenuHomeAdapter
    private lateinit var sharedPref: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = SharedPref(this)

        setUpViewMenu()
        setUpViewWallet()
        setUpViewSavingDeposit()
        setupLogout()

    }

    private fun setupLogout() {
        binding.btnLogut.setOnClickListener{
        sharedPref.clearDataPref()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
        }
    }

    private fun setUpViewWallet(){
        dummyEwalletList = createDummyEwalletList()

        binding.componentHomeEwallet.rvEwallet.adapter = ewalletAdapter
        ewalletAdapter.setDataEwallet(dummyEwalletList ?: mutableListOf())
        ewalletAdapter.setOnClickEwallet {Ewallet ->
            Toast.makeText(this, "Berhasil menghubungkan ${Ewallet.name}", Toast.LENGTH_SHORT).show()

            dummyEwalletList?.forEach{
                if (it.name == Ewallet.name) it.isConnected=true
            }
            ewalletAdapter.setDataEwallet(dummyEwalletList?.toMutableList() ?: mutableListOf())
        }
    }
    private fun createDummyEwalletList(): MutableList<EwalletModel>{
        return mutableListOf(
            EwalletModel(name = "Gopay", image = R.drawable.ic_gopay, balance = 100000.0, isConnected = true),
            EwalletModel(name = "Shopee", image = R.drawable.ic_barcode, balance = 100000.0, isConnected = false),
            EwalletModel(name = "LinkAja", image = R.drawable.ic_linkaja, balance = 100000.0, isConnected = false),
            EwalletModel(name = "Ovo", image = R.drawable.ic_ovo, balance = 100000.0, isConnected = false),
            EwalletModel(name = "Dana", image = R.drawable.ic_dana, balance = 100000.0, isConnected = false),
            EwalletModel(name = "AstraPay", image = R.drawable.ic_barcode, balance = 100000.0, isConnected = false)
        )
    }

    private fun setUpViewSavingDeposit(){
        savingDepositAdapter = SavingDepositAdapter(populateSavingDepositData())
        binding.componentHomeSavingDeposit.rvSavingDeposit.adapter = savingDepositAdapter
        updateSizeSavingDeposit(populateSavingDepositData())
    }
    private fun updateSizeSavingDeposit(data: MutableList<SavingDepositModel>){
        binding.componentHomeSavingDeposit.llShowMore.isVisible = data.size > 2
        binding.componentHomeSavingDeposit.llShowMore.setOnClickListener{
            savingDepositAdapter.updateQuantityDepositSize(data.size)
            binding.componentHomeSavingDeposit.llShowMore.visibility = View.GONE
            binding.componentHomeSavingDeposit.llShowLess.visibility = View.VISIBLE
        }
        binding.componentHomeSavingDeposit.llShowLess.setOnClickListener{
            savingDepositAdapter.updateQuantityDepositSize(2)
            binding.componentHomeSavingDeposit.llShowMore.visibility = View.VISIBLE
            binding.componentHomeSavingDeposit.llShowLess.visibility = View.GONE
        }
    }
    private fun populateSavingDepositData(): MutableList<SavingDepositModel>{
        return mutableListOf(
            SavingDepositModel(
                savingName = "Tabungan IDR NOW",
                accountNumber = "17432748372478",
                imageCard = R.drawable.ic_card_rek
            ),
            SavingDepositModel(
                savingName = "Tabungan Nikah",
                accountNumber = "17432748372478",
                imageCard = R.drawable.ic_card_rek
            ),
            SavingDepositModel(
                savingName = "Tabungan Rumah",
                accountNumber = "17432748372478",
                imageCard = R.drawable.ic_card_rek
            ),
            SavingDepositModel(
                savingName = "Tabungan Jajan",
                accountNumber = "17432748372478",
                imageCard = R.drawable.ic_card_rek
            ),
            SavingDepositModel(
                savingName = "Tabungan Anak",
                accountNumber = "17432748372478",
                imageCard = R.drawable.ic_card_rek
            ),
        )
    }
    private fun populateDataMenuHome(): List<MenuModel>{
        return listOf(
            MenuModel(
                image = R.drawable.ic_circle,
                menuTitle = "Transfer"
            ),
            MenuModel(
                image = R.drawable.ic_circle,
                menuTitle = "Donasi"
            ),
            MenuModel(
                image = R.drawable.ic_circle,
                menuTitle = "QR"
            ),
            MenuModel(
                image = R.drawable.ic_circle,
                menuTitle = "Zakat"
            ),
            MenuModel(
                image = R.drawable.ic_circle,
                menuTitle = "Cashsles"
            ),
            MenuModel(
                image = R.drawable.ic_circle,
                menuTitle = "E-Wallet"
            ),
            MenuModel(
                image = R.drawable.ic_circle,
                menuTitle = "Tarik"
            ),
            MenuModel(
                image = R.drawable.ic_circle,
                menuTitle = "Bayar"
            ),
            MenuModel(
                image = R.drawable.ic_circle,
                menuTitle = "Setor"
            )
        )
    }
    private fun setUpViewMenu(){
        menuAdapter = MenuHomeAdapter(populateDataMenuHome())
        binding.componentMenuHome.gridHome.adapter = menuAdapter

        menuAdapter.setOnClickMenu {
            Toast.makeText(this, "${it.menuTitle}", Toast.LENGTH_SHORT).show()
        }
    }
}