package com.example.cosmeticdeliveryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.cosmeticdeliveryapp.databinding.ActivityMainProductBinding
import com.example.cosmeticdeliveryapp.ui.ViewPagerResAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainProductBinding
    private lateinit var viewPager: ViewPager
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainProductBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initUI()

    }
    private fun initUI() {
        viewPager = binding.viewResPager
        bottomNavigationView=binding.bottomNav
        val viewPagerAdapter = ViewPagerResAdapter(
            fragmentManager = supportFragmentManager,
            FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        viewPager.adapter = viewPagerAdapter

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> {
                    viewPager.currentItem = 0
                }
                R.id.action_favourite -> {
                    viewPager.currentItem = 1
                }
                R.id.action_cart -> {
                    viewPager.currentItem = 2
                }
                R.id.action_user -> {
                    viewPager.currentItem = 3
                }
            }
            true
        }

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        bottomNavigationView.menu.findItem(R.id.action_home).isChecked = true
                    }
                    1 -> {
                        bottomNavigationView.menu.findItem(R.id.action_favourite).isChecked = true
                    }
                    2 -> {
                        bottomNavigationView.menu.findItem(R.id.action_cart).isChecked = true
                    }
                    4 -> {
                        bottomNavigationView.menu.findItem(R.id.action_user).isChecked = true
                    }
                    3 -> {
                        bottomNavigationView.menu.findItem(R.id.action_user).isChecked = true
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        }
        )

    }
}


