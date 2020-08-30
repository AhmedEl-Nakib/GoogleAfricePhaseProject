package com.example.googleafricephaseproject.ui.skillIQ

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.googleafricephaseproject.pojo.response.SkillIQLeadersResponseItem
import com.example.googleafricephaseproject.databinding.FragmentSkillIQLeadersBinding
import org.koin.android.ext.android.inject

class SkillIQLeadersFragment : Fragment() {

    lateinit var binding : FragmentSkillIQLeadersBinding
    var skillIQLeadersList: MutableLiveData<List<SkillIQLeadersResponseItem>> = MutableLiveData()
    private val viewModel: SkillIQLeadersViewModel by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentSkillIQLeadersBinding.inflate(inflater)
        binding.lifecycleOwner = this

        binding.vm = viewModel

        viewModel.getSkillIQLeadersList(requireContext())
        viewModel.skillIQLeadersList.observe(viewLifecycleOwner, Observer {
            if(it.isNotEmpty()) {
                skillIQLeadersList.value = it
                binding.skillIQLeadersRecyclerViewId.adapter = SkillIQLeadersRecyclerAdapter(skillIQLeadersList,requireContext())
            }
        })
        return binding.root
    }

}