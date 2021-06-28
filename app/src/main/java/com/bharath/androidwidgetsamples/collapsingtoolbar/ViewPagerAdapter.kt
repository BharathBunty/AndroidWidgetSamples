package com.bharath.androidwidgetsamples.collapsingtoolbar

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    activity: AppCompatActivity,
    val itemsCount: Int): FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return itemsCount
    }

    override fun createFragment(position: Int): Fragment {
       return TeamDetailFragment.getInstance(position)
    }
}