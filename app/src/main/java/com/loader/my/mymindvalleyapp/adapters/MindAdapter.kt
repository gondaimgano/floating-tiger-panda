package com.loader.my.mymindvalleyapp.adapters

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import gondai.myloaderlib.MyLoader


object BindView{
    @BindingAdapter("imageUrl")
    fun loadImage(v:ImageView,imageUrl:String){
        MyLoader.loadImage(imageUrl,v)
    }
}

