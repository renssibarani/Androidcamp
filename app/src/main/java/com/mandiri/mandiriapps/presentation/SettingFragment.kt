package com.mandiri.mandiriapps.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mandiri.mandiriapps.databinding.FragmenHomeBinding
import com.mandiri.mandiriapps.databinding.FragmenMessageBinding
import com.mandiri.mandiriapps.databinding.FragmentSettingBinding
import com.mandiri.mandiriapps.helper.SharedPref

class SettingFragment:Fragment() {
    private var _binding: FragmentSettingBinding? = null
    private lateinit var sharedPref: SharedPref
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = SharedPref(requireContext())
        binding.componentSettingLogout.llLogout.setOnClickListener{
            logout()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    private fun logout() {
        sharedPref.clearDataPref()
        startActivity(Intent(requireContext(), LoginActivity::class.java))

    }
}