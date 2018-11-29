package com.loader.my.mymindvalleyapp

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.loader.my.mymindvalleyapp.databinding.ActivityDetailBinding
import gondai.myloaderlib.MyLoader

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val activityDetailBinding= DataBindingUtil.setContentView<ActivityDetailBinding>(this,R.layout.activity_detail)

        val a =applicationContext as App

        MyLoader.loadImage(a.mindItemCurrent.mindItem.user.profileImage.large,activityDetailBinding.mainView)
    }
}
