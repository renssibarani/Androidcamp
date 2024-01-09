package com.mandiri.mandiriapps.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mandiri.mandiriapps.base.BaseFragment
import com.mandiri.mandiriapps.databinding.FragmentSettingBinding

class NfcFragment:BaseFragment<FragmentSettingBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSettingBinding {
        return FragmentSettingBinding.inflate(inflater, container, false)
    }

    override fun setupView() {

    }
}