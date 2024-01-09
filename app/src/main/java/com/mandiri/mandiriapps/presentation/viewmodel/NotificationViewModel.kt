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

    fun setNotificationData(data: List<NotificationModel>) = viewModelScope.launch {
        _notificationData.postValue(data)
    }

}