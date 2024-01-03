package com.mandiri.mandiriapps.presentation.message.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mandiri.mandiriapps.adapter.NotificationAdapter
import com.mandiri.mandiriapps.databinding.FragmentNotificationBinding
import com.mandiri.mandiriapps.model.NotificationModel

class NotificationFragment  : Fragment(){
    private var _binding : FragmentNotificationBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvNotification.adapter = NotificationAdapter(
            populateDateNotification()
        )
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