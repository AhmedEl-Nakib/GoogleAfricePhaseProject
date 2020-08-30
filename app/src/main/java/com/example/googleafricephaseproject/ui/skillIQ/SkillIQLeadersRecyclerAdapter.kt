package com.example.googleafricephaseproject.ui.skillIQ

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.googleafricephaseproject.pojo.response.SkillIQLeadersResponseItem
import com.example.googleafricephaseproject.databinding.SkillIqLeadersRowBinding

class SkillIQLeadersRecyclerAdapter (private var dataList: LiveData<List<SkillIQLeadersResponseItem>>,
                                     private val context: Context?) : RecyclerView.Adapter<SkillIQLeadersRecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(SkillIqLeadersRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.value!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList.value!![position] )
    }


    class ViewHolder(private var binding: SkillIqLeadersRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SkillIQLeadersResponseItem) {
            binding.model = item
            binding.executePendingBindings()

        }

    }

}