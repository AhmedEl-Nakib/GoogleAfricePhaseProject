package com.example.googleafricephaseproject.ui.learningLeaders

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.googleafricephaseproject.pojo.response.LearningLeadersResponseItem
import com.example.googleafricephaseproject.databinding.LearningLeadersRowBinding

class LearningLeadersRecyclerAdapter(private var dataList: LiveData<List<LearningLeadersResponseItem>>)
    : RecyclerView.Adapter<LearningLeadersRecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LearningLeadersRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return if(dataList.value != null)
            dataList.value!!.size
        else
            0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList.value!![position] )
        holder.itemView.setOnClickListener {
            Toast.makeText(it.rootView.context,"Success",Toast.LENGTH_SHORT).show()
        }
    }


    class ViewHolder(private var binding: LearningLeadersRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LearningLeadersResponseItem) {
            binding.model = item
            binding.executePendingBindings()

        }

    }

}