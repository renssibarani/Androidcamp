package com.mandiri.mandiriapps.presentation.message.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mandiri.mandiriapps.databinding.FragmentHistoryTrasactionBinding
import com.mandiri.mandiriapps.databinding.FragmentNotificationBinding

class HistoryTransactionFragment : Fragment() {
    private var _binding : FragmentHistoryTrasactionBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryTrasactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}