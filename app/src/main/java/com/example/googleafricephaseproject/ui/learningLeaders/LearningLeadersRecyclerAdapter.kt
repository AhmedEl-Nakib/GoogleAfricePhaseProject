package com.example.googleafricephaseproject.ui.learningLeaders

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.googleafricephaseproject.pojo.response.LearningLeadersResponseItem
import com.example.googleafricephaseproject.databinding.LearningLeadersRowBinding

class LearningLeadersRecyclerAdapter (private var dataList: LiveData<List<LearningLeadersResponseItem>>,
                                      private val context: Context?) : RecyclerView.Adapter<LearningLeadersRecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LearningLeadersRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.value!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList.value!![position] )
    }


    class ViewHolder(private var binding: LearningLeadersRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LearningLeadersResponseItem) {
            binding.model = item
            binding.executePendingBindings()

        }

    }

}