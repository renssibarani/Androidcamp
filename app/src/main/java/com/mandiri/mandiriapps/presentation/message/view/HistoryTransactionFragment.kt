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
import com.mandiri.mandiriapps.databinding.FragmentHistoryTrasactionBinding
import com.mandiri.mandiriapps.databinding.FragmentNotificationBinding
import com.mandiri.mandiriapps.model.HistoryTransactionModel

class HistoryTransactionFragment : Fragment() {
    private var _historyAdapter: HistoryTransactionAdapter? = null
    private var _historyTransactionData: List<HistoryTransactionModel>? = null
    private var _binding: FragmentHistoryTrasactionBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryTrasactionBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

                    if (position==0) {
                        _historyAdapter?.filterTransactionData(populateDataHistoryTransaction())
                    }else{
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupViewHistoryTransaction() {
        _historyTransactionData = populateDataHistoryTransaction()
        _historyAdapter = HistoryTransactionAdapter(
            listTransaction = populateDataHistoryTransaction(),
            onClickHistoryTransaction = {
                DetailTransactionActivity.navigateToDetailTransaction(
                    activity = requireActivity(),
                    data = it
                )
            }
        )
        binding.rvTransaction.adapter = _historyAdapter
    }

    //    private fun navigateToDetailHistory(data: HistoryTransactionModel){
//        val intent = Intent(context, DetailTransactionActivity::class.java)
//        intent.putExtra("", data)
//        startActivity(intent)
//    }
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