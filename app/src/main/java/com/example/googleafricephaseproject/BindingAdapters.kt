package com.example.googleafricephaseproject

import android.annotation.SuppressLint
import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso


object BindingAdapters{

    @BindingAdapter("imageUrl")
    @JvmStatic //https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/
    fun loadImage(view: ImageView, url: String) = Picasso.get().load(url).into(view)


}