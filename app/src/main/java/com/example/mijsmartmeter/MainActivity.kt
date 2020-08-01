package com.example.mijsmartmeter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var pagerAdapter:MyPagerAdapter
    private lateinit var viewPager:ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        val  viewpager_main:ViewPager = findViewById(R.id.pager)
        val tabs:TabLayout = findViewById(R.id.tabs)

        viewpager_main.adapter = fragmentAdapter

        tabs.setupWithViewPager(viewpager_main)




    }


    class MyPagerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm,FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){


        override fun getItem(position: Int): Fragment {

            return when(position){
                0 -> {
                    OnlineFragment()
                }
                1 -> USBFragment()
                else -> {
                    return WiFiFragment()
                }
            }


        }
        override fun getCount(): Int {
            return 3
        }
        override fun getPageTitle(position: Int): CharSequence {
            return when (position) {
                0 -> "ONLINE"
                1 -> "USB"
                else -> {
                    return "WiFi"
                }
            }
        }
    }
}
