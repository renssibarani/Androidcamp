package com.mandiri.mandiriapps.presentation

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.base.BaseFragment
import com.mandiri.mandiriapps.databinding.FragmentSettingBinding
import com.mandiri.mandiriapps.helper.SharedPrefHelper
import com.mandiri.mandiriapps.utils.ConfirmationDialogUtil
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SettingFragment : BaseFragment<FragmentSettingBinding>() {
    private lateinit var confirmationDialogUtil: ConfirmationDialogUtil
    @Inject
    lateinit var sharedPrefHelper: SharedPrefHelper
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSettingBinding {
        return FragmentSettingBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        confirmationDialogUtil = ConfirmationDialogUtil(requireContext())
        binding.componentSettingLogout.llLogout.setOnClickListener {
            showConfirmation()
                    }
    }


    private fun logout() {
        sharedPrefHelper.clearDataPref()
        startActivity(Intent(requireContext(), LoginActivity::class.java))
    }

    private fun showConfirmation() {
        val title = "Konfirmasi"
        val icon = R.drawable.ic_run_livin
        confirmationDialogUtil.showConfirmationDialog(
            title,
            icon,
            onConfirm =
            {
                logout()
            },
            onCancle =
            {

            }
        )
    }
}