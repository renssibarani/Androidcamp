package com.mandiri.mandiriapps.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.adapter.CredirCardAdapter
import com.mandiri.mandiriapps.adapter.EwalletAdapter
import com.mandiri.mandiriapps.adapter.MenuHomeAdapter
import com.mandiri.mandiriapps.adapter.SavingDepositAdapter
import com.mandiri.mandiriapps.databinding.FragmenHomeBinding
import com.mandiri.mandiriapps.model.CreditCardModel
import com.mandiri.mandiriapps.model.EwalletModel
import com.mandiri.mandiriapps.model.MenuModel
import com.mandiri.mandiriapps.model.SavingDepositModel

class HomeFragment : Fragment() {
    private var _binding: FragmenHomeBinding? = null
    private val binding get() = _binding!!
    private var ewalletAdapter = EwalletAdapter()
    private var dummyEwalletList: MutableList<EwalletModel>? = null
    private lateinit var savingDepositAdapter: SavingDepositAdapter
    private lateinit var creditCardAdapter : CredirCardAdapter
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
        setupViewCreditCard()
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
    private fun setupViewCreditCard(){
        creditCardAdapter = CredirCardAdapter(populateCredirCard())
        binding.componentCreditCard.rvCreditCard.adapter = creditCardAdapter

    }
    private fun setUpViewSavingDeposit() {
        savingDepositAdapter = SavingDepositAdapter(populateSavingDepositData())
        binding.componentHomeSavingDeposit.rvSavingDeposit.adapter = savingDepositAdapter
        updateSizeSavingDeposit(populateSavingDepositData())
        updateHideOpenSavingDeposit()
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
    private fun toggleSavingDepositBalanceVisibility(isVisible: Boolean) {
        for (i in 0 until savingDepositAdapter.itemCount) {
            (binding.componentHomeSavingDeposit.rvSavingDeposit.findViewHolderForAdapterPosition(i) as? SavingDepositAdapter.SavingDepositViewHolder)?.setBalanceVisibility(isVisible)
        }
    }


    private fun updateHideOpenSavingDeposit(){
        binding.componentHomeSavingDeposit.llBalanceHide.setOnClickListener{
            binding.componentHomeSavingDeposit.llBalanceHide.visibility = View.GONE
            binding.componentHomeSavingDeposit.llBalanceOpen.visibility = View.VISIBLE
            toggleSavingDepositBalanceVisibility(true)
        }
        binding.componentHomeSavingDeposit.llBalanceOpen.setOnClickListener{
            binding.componentHomeSavingDeposit.llBalanceHide.visibility = View.VISIBLE
            binding.componentHomeSavingDeposit.llBalanceOpen.visibility = View.GONE
            toggleSavingDepositBalanceVisibility(false)
        }
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

    private fun populateCredirCard():List<CreditCardModel>{
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
            ),CreditCardModel(
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

    private fun setUpViewMenu() {
        menuAdapter = MenuHomeAdapter(populateDataMenuHome())
        binding.componentMenuHome.gridHome.adapter = menuAdapter

        menuAdapter.setOnClickMenu {
            Toast.makeText(context, "${it.menuTitle}", Toast.LENGTH_SHORT).show()
        }
    }


}