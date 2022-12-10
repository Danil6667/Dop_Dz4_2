package com.danil.dop_dz4_2.ui.fragment.tablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.danil.dop_dz4_2.R
import com.danil.dop_dz4_2.databinding.FragmentTabLayoutBinding
import com.danil.dop_dz4_2.ui.adapter.FragmentPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutFragment : Fragment() {

    private lateinit var binding: FragmentTabLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTabLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initial()
    }

    private fun initial() {
        binding.viewPager.adapter = FragmentPagerAdapter(this)
//        binding.tabLayout.tabIconTint = null   < должен был обнулять дефолтный цвет иконки, НО он у меня он так и так работает!
        TabLayoutMediator(binding.tabLayout, binding.viewPager){
                tab, pos ->
            when(pos){
                0 -> {
                    tab.setIcon(R.drawable.ic_hand)
                    tab.icon?.setTint(ContextCompat.getColor(requireContext(),R.color.teal_700))
                    tab.icon?.alpha = 250 // Здесь выставляю начальную прозрачность иконки
                }
                1 -> {
                    tab.setIcon(R.drawable.ic_note)
                    tab.icon?.setTint(ContextCompat.getColor(requireContext(),R.color.purple_200))
                    tab.icon?.alpha = 70 // Здесь выставляю начальную прозрачность иконки
                }
            }
        }.attach()

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                tab.icon?.alpha = 250
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.icon?.alpha = 70
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}
            // Этим методом я регулирую прозрачностью иконки
        })
    }
}