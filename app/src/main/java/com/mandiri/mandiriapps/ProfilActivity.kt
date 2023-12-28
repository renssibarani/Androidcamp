package com.mandiri.mandiriapps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mandiri.mandiriapps.RegisterActivity.Companion.KEY_ALAMAT_VALUE
import com.mandiri.mandiriapps.RegisterActivity.Companion.KEY_GENDER_VALUE
import com.mandiri.mandiriapps.RegisterActivity.Companion.KEY_NAME_VALUE
import com.mandiri.mandiriapps.RegisterActivity.Companion.KEY_UMUR_VALUE
import com.mandiri.mandiriapps.databinding.ActivityProfilBinding

class ProfilActivity:AppCompatActivity() {
    private lateinit var binding:ActivityProfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(KEY_NAME_VALUE)
        binding.tvNameProfil.text = name
        binding.tvTitleProfil.text=name
        val umur = intent.getStringExtra(KEY_UMUR_VALUE)
        binding.tvUmur.text=umur
        val alamat = intent.getStringExtra(KEY_ALAMAT_VALUE)
        binding.tvAlamat.text=alamat
        val gender = intent.getStringExtra(KEY_GENDER_VALUE)
        binding.tvGender.text=gender
    }
}