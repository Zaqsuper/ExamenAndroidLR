package com.example.examenandroidlr.datares

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("visible")
fun View.bindVisible(visible: Boolean?){
    visibility = if (visible == true) View.VISIBLE else View.GONE
}

@BindingAdapter("ImageConverter")
fun ImageView.imageConverter(url: String?){
    Picasso.get().load(url).into(this)
}