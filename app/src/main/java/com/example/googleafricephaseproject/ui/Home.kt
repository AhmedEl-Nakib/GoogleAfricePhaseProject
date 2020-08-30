package com.example.googleafricephaseproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.googleafricephaseproject.R
import com.example.googleafricephaseproject.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout

class Home : Fragment() {

    lateinit var binding : FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Learning Leaders"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Skill IQ Leaders"))
        binding.tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = MyAdapter(requireContext(), childFragmentManager, binding.tabLayout.tabCount)
        binding.viewPager.adapter = adapter

        binding.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        binding.btnSubmitId.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_home2_to_projectSubmissionFragment)
        }


    return binding.root
    }


}