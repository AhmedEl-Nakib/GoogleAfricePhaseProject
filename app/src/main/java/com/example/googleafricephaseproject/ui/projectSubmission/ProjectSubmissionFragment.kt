package com.example.googleafricephaseproject.ui.projectSubmission

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.googleafricephaseproject.databinding.FragmentProjectSubmissionBinding
import org.koin.android.ext.android.inject

class ProjectSubmissionFragment : Fragment() {

    lateinit var binding : FragmentProjectSubmissionBinding
    private val viewModel: ProjectSubmissionViewModel by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentProjectSubmissionBinding.inflate(inflater)
        binding.lifecycleOwner = this

        binding.vm = viewModel

        binding.back.setOnClickListener {
            activity!!.onBackPressed()
        }
        return binding.root
    }

}