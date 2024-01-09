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
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.adapter.HistoryTransactionAdapter
import com.mandiri.mandiriapps.base.BaseFragment
import com.mandiri.mandiriapps.databinding.FragmentHistoryTrasactionBinding
import com.mandiri.mandiriapps.databinding.FragmentNotificationBinding
import com.mandiri.mandiriapps.model.HistoryTransactionModel
import com.mandiri.mandiriapps.model.StatusTransfer
import com.mandiri.mandiriapps.model.statusTransaction
import com.mandiri.mandiriapps.utils.ConfirmationDialogUtil

class HistoryTransactionFragment : BaseFragment<FragmentHistoryTrasactionBinding>() {
    private var _historyAdapter: HistoryTransactionAdapter? = null
    private var _historyTransactionData: List<HistoryTransactionModel>? = null
    private var _binding: FragmentHistoryTrasactionBinding? = null
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHistoryTrasactionBinding {
        return FragmentHistoryTrasactionBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        setupViewHistoryTransaction()


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
                        _historyAdapter?.filterTransactionData(populateDataHistoryTransaction())
                    } else {
                        populateDataHistoryTransaction().filter {
                            it.titleTrasaction.equals(
                                spinnerValue
                            )
                        }.also { historyData ->
                            _historyAdapter?.filterTransactionData(historyData)
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

            }
    }

    private lateinit var confirmationDialogUtil: ConfirmationDialogUtil


    private fun setupViewHistoryTransaction() {
        _historyTransactionData = populateDataHistoryTransaction()
        _historyAdapter = HistoryTransactionAdapter(
            listTransaction = populateDataHistoryTransaction(),
            onClickHistoryTransaction = {
                showConfirmation(it)
            }
        )
        binding.rvTransaction.adapter = _historyAdapter
    }

    //    private fun navigateToDetailHistory(data: HistoryTransactionModel){
//        val intent = Intent(context, DetailTransactionActivity::class.java)
//        intent.putExtra("", data)
//        startActivity(intent)
//    }
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