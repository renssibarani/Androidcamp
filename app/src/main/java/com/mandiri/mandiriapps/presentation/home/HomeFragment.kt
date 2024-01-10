package com.mandiri.mandiriapps.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.adapter.CredirCardAdapter
import com.mandiri.mandiriapps.adapter.EwalletAdapter
import com.mandiri.mandiriapps.adapter.MenuHomeAdapter
import com.mandiri.mandiriapps.adapter.SavingDepositAdapter
import com.mandiri.mandiriapps.base.BaseFragment
import com.mandiri.mandiriapps.databinding.FragmenHomeBinding
import com.mandiri.mandiriapps.model.CreditCardModel
import com.mandiri.mandiriapps.model.EwalletModel
import com.mandiri.mandiriapps.model.MenuModel
import com.mandiri.mandiriapps.model.SavingDepositModel
import com.mandiri.mandiriapps.presentation.home.viewmodel.HomeViewModel
import com.mandiri.mandiriapps.presentation.viewmodel.NotificationViewModel

class HomeFragment : BaseFragment<FragmenHomeBinding>() {
    private val viewModel: HomeViewModel by viewModels()
    private var ewalletAdapter = EwalletAdapter()
    private var dummyEwalletList: MutableList<EwalletModel>? = null
    private lateinit var savingDepositAdapter: SavingDepositAdapter
    private lateinit var creditCardAdapter: CredirCardAdapter
    private lateinit var menuAdapter: MenuHomeAdapter
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmenHomeBinding {
        return FragmenHomeBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewModel.setMenuHomeData()
        viewModel.setEwalletData()
        viewModel.setSavingDepositData()
        viewModel.setCreditCardData()
        observeViewModel()
    }

    private fun setUpViewWallet(data: MutableList<EwalletModel>) {
        dummyEwalletList = data

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

    private fun observeViewModel() {
        viewModel.ewalletData.observe(viewLifecycleOwner) {
            setUpViewWallet(it)
        }
        viewModel.savingDepositData.observe(viewLifecycleOwner) {
            setUpViewSavingDeposit(it)
        }
        viewModel.creditCardData.observe(viewLifecycleOwner){
            setupViewCreditCard(it)
        }
        viewModel.menuHomeData.observe(viewLifecycleOwner){
            setUpViewMenu(it)
        }
    }

    private fun setupViewCreditCard(data: List<CreditCardModel>) {
        creditCardAdapter = CredirCardAdapter(data)
        binding.componentCreditCard.rvCreditCard.adapter = creditCardAdapter

    }
    private fun setUpViewSavingDeposit(data: MutableList<SavingDepositModel>) {
        savingDepositAdapter = SavingDepositAdapter(data)
        binding.componentHomeSavingDeposit.rvSavingDeposit.adapter = savingDepositAdapter
        updateSizeSavingDeposit(data)
        updateHideOpenSavingDeposit()
    }
    private fun setUpViewMenu(data: List<MenuModel>) {
        menuAdapter = MenuHomeAdapter(data)
        binding.componentMenuHome.gridHome.adapter = menuAdapter

        menuAdapter.setOnClickMenu {
            Toast.makeText(context, "${it.menuTitle}", Toast.LENGTH_SHORT).show()
        }
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
            (binding.componentHomeSavingDeposit.rvSavingDeposit.findViewHolderForAdapterPosition(
                i
            ) as? SavingDepositAdapter.SavingDepositViewHolder)?.setBalanceVisibility(
                isVisible
            )
        }
    }

    private fun updateHideOpenSavingDeposit() {
        binding.componentHomeSavingDeposit.llBalanceHide.setOnClickListener {
            binding.componentHomeSavingDeposit.llBalanceHide.visibility = View.GONE
            binding.componentHomeSavingDeposit.llBalanceOpen.visibility = View.VISIBLE
            toggleSavingDepositBalanceVisibility(true)
        }
        binding.componentHomeSavingDeposit.llBalanceOpen.setOnClickListener {
            binding.componentHomeSavingDeposit.llBalanceHide.visibility = View.VISIBLE
            binding.componentHomeSavingDeposit.llBalanceOpen.visibility = View.GONE
            toggleSavingDepositBalanceVisibility(false)
        }
    }



}
