package com.mandiri.mandiriapps.presentation.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.mandiri.mandiriapps.adapter.MessageTabAdapter
import com.mandiri.mandiriapps.databinding.FragmenMessageBinding
import com.mandiri.mandiriapps.model.NotificationModel
import com.mandiri.mandiriapps.presentation.message.view.HistoryTransactionFragment
import com.mandiri.mandiriapps.presentation.message.view.NotificationFragment

class MessageFragment : Fragment() {
    private var _binding: FragmenMessageBinding? = null
    private val binding get() = _binding!!

    private var adapterMessage: MessageTabAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmenMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTabView()
    }

    private fun setupTabView() {
        val tabLayout = binding.tabMessage
        val viewPager = binding.vpMessage
        adapterMessage = MessageTabAdapter(this)
        adapterMessage?.addListFragment(NotificationFragment())
        adapterMessage?.addListFragment(HistoryTransactionFragment())
        viewPager.adapter = adapterMessage

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Notification"
                }

                1 -> {
                    tab.text = "History"
                }
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}