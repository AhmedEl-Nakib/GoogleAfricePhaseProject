package com.example.googleafricephaseproject

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.googleafricephaseproject.pojo.response.LearningLeadersResponseItem
import com.example.googleafricephaseproject.ui.learningLeaders.LearningLeadersRecyclerAdapter
import com.squareup.picasso.Picasso


object BindingAdapters{

    @BindingAdapter("imageUrl")
    @JvmStatic //https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/
    fun loadImage(view: ImageView, url: String) = Picasso.get().load(url).into(view)

    @BindingAdapter("setLearningLeadersData" )
    @JvmStatic
    fun setLearningLeadersData(recyclerView : RecyclerView, data : LiveData<List<LearningLeadersResponseItem>> ) {
        recyclerView.adapter = LearningLeadersRecyclerAdapter(data)
    }
}