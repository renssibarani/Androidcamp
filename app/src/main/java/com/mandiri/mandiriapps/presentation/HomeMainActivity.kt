package com.mandiri.mandiriapps.presentation

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.databinding.HomeMainActivityBinding
import com.mandiri.mandiriapps.helper.SharedPrefHelper
import com.mandiri.mandiriapps.presentation.home.HomeFragment
import com.mandiri.mandiriapps.presentation.message.MessageFragment
import com.mandiri.mandiriapps.utils.ConfirmationDialogUtil
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeMainActivity : AppCompatActivity() {
    private lateinit var binding: HomeMainActivityBinding
    @Inject
    lateinit var sharedPrefHelper: SharedPrefHelper
    private lateinit var confirmationDialogUtil: ConfirmationDialogUtil

    private val onNavigateItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationHome -> {
                    replaceFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationMessage -> {
                    replaceFragment(MessageFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationPromo -> {
                    replaceFragment(PromoFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationSetting -> {
                    replaceFragment(SettingFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationLogout -> {
                    showConfirmation()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun logout() {
        sharedPrefHelper.clearDataPref()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun showConfirmation() {
        val title = "Konfirmasi"
        val icon = R.drawable.ic_run_livin
        confirmationDialogUtil.showConfirmationDialog(
            title,
            icon,
            onConfirm = {
                logout()
            },
            onCancle = {

            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeMainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        confirmationDialogUtil = ConfirmationDialogUtil(this)

        binding.bottomNavigation.setOnNavigationItemSelectedListener(onNavigateItemSelectedListener)
        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.navigationHome
        }
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        builder
            .setTitle("Apakah Yakin ?")
            .setMessage("Ingin Keluar Dari Livin ?")
            .setPositiveButton("Ya") { _: DialogInterface, _: Int ->
                logout()
            }.setNegativeButton("Tidak") { _: DialogInterface, _: Int ->

            }
        val dialog = builder.create()
        dialog.show()
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmenContainer, fragment)
            .commit()
    }
}