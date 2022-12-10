package com.danil.dop_dz4_2.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.danil.dop_dz4_2.ui.fragment.pager.FirstFragment
import com.danil.dop_dz4_2.ui.fragment.pager.SecondFragment

class FragmentPagerAdapter (fragment: Fragment): FragmentStateAdapter(fragment){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment()
            else -> SecondFragment()
        }
    }
}