package com.unicorn.justjob.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.unicorn.justjob.databinding.FraMainBinding
import com.unicorn.justjob.ui.base.BaseFra

class MainFra : BaseFra<FraMainBinding>(FraMainBinding::inflate) {

    override fun init() {
        binding.apply {
            viewPager2.adapter = MainPagerAdapter(this@MainFra)
        }
    }

}

class MainPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return ListFra()
    }

}