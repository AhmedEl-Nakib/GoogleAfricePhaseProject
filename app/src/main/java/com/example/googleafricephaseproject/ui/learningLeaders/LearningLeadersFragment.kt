package com.example.googleafricephaseproject.ui.learningLeaders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.googleafricephaseproject.pojo.response.LearningLeadersResponseItem
import com.example.googleafricephaseproject.databinding.FragmentLearningLeadersBinding
import org.koin.android.ext.android.inject

class LearningLeadersFragment : Fragment() {

    lateinit var binding : FragmentLearningLeadersBinding
    var learningLeadersList: MutableLiveData<List<LearningLeadersResponseItem>> = MutableLiveData()
    private val viewModel: LearningLeadersViewModel by inject()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentLearningLeadersBinding.inflate(inflater)
        binding.lifecycleOwner = this

        binding.vm = viewModel

        viewModel.getLearningLeadersList(requireContext())
        viewModel.learningLeadersList.observe(viewLifecycleOwner, Observer {
            if(it.isNotEmpty()) {
                learningLeadersList.value = it
                binding.learningLeadersRecyclerViewId.adapter = LearningLeadersRecyclerAdapter(learningLeadersList,requireContext())
            }
        })
        return binding.root
    }

}