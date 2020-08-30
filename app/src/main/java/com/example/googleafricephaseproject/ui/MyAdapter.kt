package com.example.googleafricephaseproject.ui

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.googleafricephaseproject.ui.learningLeaders.LearningLeadersFragment
import com.example.googleafricephaseproject.ui.skillIQ.SkillIQLeadersFragment

class MyAdapter (private val myContext: Context, fm: FragmentManager, private var totalTabs: Int) : FragmentPagerAdapter(fm) {

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                LearningLeadersFragment()
            }
            1 -> {
                SkillIQLeadersFragment()
            }

            else -> LearningLeadersFragment()
        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }
}