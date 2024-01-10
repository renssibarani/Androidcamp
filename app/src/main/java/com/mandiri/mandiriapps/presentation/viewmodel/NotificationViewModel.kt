package com.mandiri.mandiriapps.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mandiri.mandiriapps.model.NotificationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor() : ViewModel() {
    private val _notificationData = MutableLiveData<List<NotificationModel>>()
    val notificationData: LiveData<List<NotificationModel>>
        get() = _notificationData

    fun setNotificationData() = viewModelScope.launch {
        _notificationData.postValue(populateDataNotification())
    }

    private fun populateDataNotification(): List<NotificationModel> {
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