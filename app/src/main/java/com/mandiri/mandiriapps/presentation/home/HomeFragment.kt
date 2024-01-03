package com.mandiri.mandiriapps.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.adapter.EwalletAdapter
import com.mandiri.mandiriapps.adapter.MenuHomeAdapter
import com.mandiri.mandiriapps.adapter.SavingDepositAdapter
import com.mandiri.mandiriapps.databinding.FragmenHomeBinding
import com.mandiri.mandiriapps.model.EwalletModel
import com.mandiri.mandiriapps.model.MenuModel
import com.mandiri.mandiriapps.model.SavingDepositModel

class HomeFragment : Fragment() {
    private var _binding: FragmenHomeBinding? = null
    private val binding get() = _binding!!
    private var ewalletAdapter = EwalletAdapter()
    private var dummyEwalletList: MutableList<EwalletModel>? = null
    private lateinit var savingDepositAdapter: SavingDepositAdapter
    private lateinit var menuAdapter: MenuHomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmenHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewMenu()
        setUpViewWallet()
        setUpViewSavingDeposit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpViewWallet() {
        dummyEwalletList = createDummyEwalletList()

        binding.componentHomeEwallet.rvEwallet.adapter = ewalletAdapter
        ewalletAdapter.setDataEwallet(dummyEwalletList ?: mutableListOf())
        ewalletAdapter.setOnClickEwallet { Ewallet ->
            Toast.makeText(context, "Berhasil menghubungkan ${Ewallet.name}", Toast.LENGTH_SHORT)
                .show()

            dummyEwalletList?.forEach {
                if (it.name == Ewallet.name) it.isConnected = true
            }
            ewalletAdapter.setDataEwallet(dummyEwalletList?.toMutableList() ?: mutableListOf())
        }
    }

    private fun createDummyEwalletList(): MutableList<EwalletModel> {
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

    private fun setUpViewSavingDeposit() {
        savingDepositAdapter = SavingDepositAdapter(populateSavingDepositData())
        binding.componentHomeSavingDeposit.rvSavingDeposit.adapter = savingDepositAdapter
        updateSizeSavingDeposit(populateSavingDepositData())
    }

    private fun updateSizeSavingDeposit(data: MutableList<SavingDepositModel>) {
        binding.componentHomeSavingDeposit.llShowMore.isVisible = data.size > 2
        binding.componentHomeSavingDeposit.llShowMore.setOnClickListener {
            savingDepositAdapter.updateQuantityDepositSize(data.size)
            binding.componentHomeSavingDeposit.llShowMore.visibility = View.GONE
            binding.componentHomeSavingDeposit.llShowLess.visibility = View.VISIBLE
        }
        binding.componentHomeSavingDeposit.llShowLess.setOnClickListener {
            savingDepositAdapter.updateQuantityDepositSize(2)
            binding.componentHomeSavingDeposit.llShowMore.visibility = View.VISIBLE
            binding.componentHomeSavingDeposit.llShowLess.visibility = View.GONE
        }
    }

    private fun populateSavingDepositData(): MutableList<SavingDepositModel> {
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

    private fun setUpViewMenu() {
        menuAdapter = MenuHomeAdapter(populateDataMenuHome())
        binding.componentMenuHome.gridHome.adapter = menuAdapter

        menuAdapter.setOnClickMenu {
            Toast.makeText(context, "${it.menuTitle}", Toast.LENGTH_SHORT).show()
        }
    }


}