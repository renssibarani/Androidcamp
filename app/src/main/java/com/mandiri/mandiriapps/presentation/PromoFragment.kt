package com.mandiri.mandiriapps.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.base.BaseFragment
import com.mandiri.mandiriapps.databinding.FragmenHomeBinding
import com.mandiri.mandiriapps.databinding.FragmenPromoBinding

class PromoFragment : BaseFragment<FragmenPromoBinding>() {
    private var _binding: FragmenPromoBinding? = null
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmenPromoBinding {
        return FragmenPromoBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        binding.btnLoadImage.setOnClickListener {
            loadImage()
        }
    }

    private fun loadImage() {
        val imageUrl = "https://picsum.photos/200"

        // Memuat gambar menggunakan Glide
        Glide.with(this)
            .load(imageUrl)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .placeholder(R.drawable.ic_placeholder)
            .into(binding.ivGlide)
    }

}