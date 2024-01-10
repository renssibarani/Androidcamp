package com.mandiri.mandiriapps.presentation.message.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mandiri.mandiriapps.adapter.NotificationAdapter
import com.mandiri.mandiriapps.base.BaseFragment
import com.mandiri.mandiriapps.databinding.FragmentNotificationBinding
import com.mandiri.mandiriapps.model.NotificationModel
import com.mandiri.mandiriapps.presentation.viewmodel.NotificationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {
    private val viewModel: NotificationViewModel by viewModels()
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewModel.setNotificationData()
        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.notificationData.observe(viewLifecycleOwner){
            setNotificationData(it)
        }
    }

    private fun setNotificationData(data: List<NotificationModel>){
        binding.rvNotification.adapter = NotificationAdapter(data)
    }




}