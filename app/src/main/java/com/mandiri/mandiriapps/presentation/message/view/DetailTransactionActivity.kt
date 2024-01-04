package com.mandiri.mandiriapps.presentation.message.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mandiri.mandiriapps.databinding.ActivityDetailTransactionBinding

class DetailTransactionActivity : AppCompatActivity(){
    private lateinit var binding: ActivityDetailTransactionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.componentToolbar.tvToolbarTitle.text = "History"
    }
}