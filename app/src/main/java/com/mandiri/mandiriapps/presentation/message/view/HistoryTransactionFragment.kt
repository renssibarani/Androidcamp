package com.mandiri.mandiriapps.presentation.message.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.adapter.HistoryTransactionAdapter
import com.mandiri.mandiriapps.base.BaseFragment
import com.mandiri.mandiriapps.databinding.FragmentHistoryTrasactionBinding
import com.mandiri.mandiriapps.databinding.FragmentNotificationBinding
import com.mandiri.mandiriapps.model.HistoryTransactionModel
import com.mandiri.mandiriapps.model.StatusTransfer
import com.mandiri.mandiriapps.model.statusTransaction
import com.mandiri.mandiriapps.presentation.viewmodel.HistoryTransactionViewModel
import com.mandiri.mandiriapps.utils.ConfirmationDialogUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryTransactionFragment : BaseFragment<FragmentHistoryTrasactionBinding>() {
    private var _historyAdapter: HistoryTransactionAdapter? = null
    private var _historyTransactionData: List<HistoryTransactionModel>? = null

    private val viewModel: HistoryTransactionViewModel by viewModels()
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHistoryTrasactionBinding {
        return FragmentHistoryTrasactionBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewModel.setHistoryTransactionData()
        observeViewModel()


        val items = arrayOf("Semua", "Debit", "Credit")
        binding.spFilterTransaction.adapter =
            ArrayAdapter(
                requireContext(),
                com.google.android.material.R.layout.support_simple_spinner_dropdown_item,
                items
            )

        binding.spFilterTransaction.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val spinnerValue = parent?.getItemAtPosition(position).toString()
                    binding.tvFilter.text = spinnerValue
//                    Toast.makeText(requireContext(), spinnerValue, Toast.LENGTH_SHORT).show()

                    if (position == 0) {
                        viewModel.historyTransactionData.value?.let {
                            _historyAdapter?.filterTransactionData(it)
                        }
                    } else {
                        viewModel.historyTransactionData.value?.filter {
                            it.titleTrasaction.equals(
                                spinnerValue
                            )
                        }?.also { historyData ->
                            _historyAdapter?.filterTransactionData(historyData)
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

            }
    }

    private lateinit var confirmationDialogUtil: ConfirmationDialogUtil
    private fun observeViewModel() {
        viewModel.historyTransactionData.observe(viewLifecycleOwner) {
            setupViewHistoryTransaction(it)
        }
    }

    private fun setupViewHistoryTransaction(data: List<HistoryTransactionModel>) {
        _historyTransactionData = data
        _historyAdapter = HistoryTransactionAdapter(
            listTransaction = data,
            onClickHistoryTransaction = {
                showConfirmation(it)
            }
        )
        binding.rvTransaction.adapter = _historyAdapter
    }

    private fun showConfirmation(data: HistoryTransactionModel) {
        ConfirmationDialogUtil(requireContext()).showConfirmationDialog(
            title = data.titleTrasaction,
            icon = checkIconForDialog(data),
            onConfirm = {
                DetailTransactionActivity.navigateToDetailTransaction(
                    activity = requireActivity(),
                    data = data
                )
            },
            onCancle = {

            }
        )
    }

    private fun checkIconForDialog(data: HistoryTransactionModel): Int {
        return when (data.titleTrasaction) {
            StatusTransfer.Debit.value -> {
                R.drawable.ic_in_transaction
            }

            StatusTransfer.Credit.value -> {
                R.drawable.ic_out
            }

            else -> {
                R.drawable.ic_in_transaction
            }
        }
    }

}