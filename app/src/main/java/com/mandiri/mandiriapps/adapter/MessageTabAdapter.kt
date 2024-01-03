package com.mandiri.mandiriapps.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MessageTabAdapter(
    fragment: Fragment,
) : FragmentStateAdapter(
    fragment.childFragmentManager,
    fragment.lifecycle
) {
    private val fragmentContent = arrayListOf<Fragment>()
    fun addListFragment(fragment: Fragment){
        fragmentContent.add(fragment)
    }

    override fun getItemCount() = fragmentContent.size

    override fun createFragment(position: Int): Fragment {
        return fragmentContent[position]
    }
}