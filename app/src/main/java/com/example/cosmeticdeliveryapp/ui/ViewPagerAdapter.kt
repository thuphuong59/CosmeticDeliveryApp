package com.example.cosmeticdeliveryapp.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerResAdapter (fragmentManager: FragmentManager, behavior: Int) : FragmentStatePagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return HomeFragment()
            }
            1 -> {
                return FavouriteFragment()
            }
            2 -> {
                return CartFragment()
            }
            3 -> {
                return UserFragment()
            }
            else -> {
                return HomeFragment()
            }
        }
    }
}