package com.kade.derayanbimaalamsyah.finalprojectkade.adapter

import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter

class ViewPagerAdapter(manager: FragmentManager) : FragmentStatePagerAdapter(manager) {


    private val fragments = ArrayList<Fragment>()
    private val titles = ArrayList<String>()

    override fun getItem(position: Int): Fragment = fragments.get(position)

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence? = titles.get(position)

    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        titles.add(title)
    }
}