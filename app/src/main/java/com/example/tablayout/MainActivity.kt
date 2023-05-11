package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import mohit.dev.digitalsoc.code.view.Frag_Files
import mohit.dev.digitalsoc.code.view.Frag_Media
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var mytablayout: TabLayout
    var myviewpager: ViewPager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        mytablayout = findViewById(R.id.mytablayout)
        myviewpager = findViewById(R.id.myviewpager)
        loadtabs(mytablayout)

    }

    private fun loadtabs(
        tab_layout: TabLayout,

        ) {
        if (tab_layout.isVisible) {
            load_viewpager()
        }
    }

    private fun load_viewpager() {

        mytablayout!!.tabGravity = TabLayout.GRAVITY_FILL

        setViewPager(myviewpager!!)
        mytablayout!!.setupWithViewPager(myviewpager)


    }

    fun setViewPager(viewPager: ViewPager) {
        var adapter: ViewPagerAdapter =
            ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(Frag_Files(), "Media")
        adapter.addFragment(Frag_Media(), "Files")
        adapter.addFragment(Frag_links(), "link")


        viewPager.adapter = adapter
    }


    class ViewPagerAdapter : FragmentPagerAdapter {
        var fragmentList: ArrayList<Fragment> = ArrayList()
        var fragmentTitleList: ArrayList<String> = ArrayList()

        constructor(supportFragmentManager: FragmentManager) : super(supportFragmentManager)

        override fun getCount(): Int {
            return fragmentList.size
        }

        override fun getItem(position: Int): Fragment {
            return fragmentList.get(position)
        }

        override fun getPageTitle(position: Int): String {
            return fragmentTitleList.get(position)
        }


        fun addFragment(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            fragmentTitleList.add(title)

        }


    }
}