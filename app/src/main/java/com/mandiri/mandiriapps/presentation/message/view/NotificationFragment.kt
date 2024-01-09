package com.mandiri.mandiriapps.presentation.message.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
    private var _binding: FragmentNotificationBinding? = null
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewModel.setNotificationData(populateDateNotification())
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


    private fun populateDateNotification(): List<NotificationModel> {
        return listOf(
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
        )
    }


}