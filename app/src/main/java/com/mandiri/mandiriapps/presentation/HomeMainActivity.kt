package com.mandiri.mandiriapps.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.databinding.HomeMainActivityBinding
import com.mandiri.mandiriapps.helper.SharedPref
import com.mandiri.mandiriapps.presentation.home.HomeFragment
import com.mandiri.mandiriapps.presentation.message.MessageFragment

class HomeMainActivity : AppCompatActivity() {
    private lateinit var binding: HomeMainActivityBinding
    private lateinit var sharedPref: SharedPref

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
                    logout()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun logout() {
        sharedPref.clearDataPref()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeMainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref = SharedPref(this)

        binding.bottomNavigation.setOnNavigationItemSelectedListener(onNavigateItemSelectedListener)
        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.navigationHome
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmenContainer, fragment)
            .commit()
    }
}