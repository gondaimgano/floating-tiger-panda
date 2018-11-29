package com.loader.my.mymindvalleyapp

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.loader.my.mymindvalleyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var adapterList: MyMindAdapterList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


      activityMainBinding=DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
       val provider=ViewModelProviders.of(this).get(MainViewModel::class.java)

        adapterList=MyMindAdapterList {
            (applicationContext as App).mindItemCurrent=it
          this.startActivity(Intent(this,DetailActivity::class.java))
        }.also {
            activityMainBinding.list.apply {
                adapter=it
                layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
            }
        }


     provider.itemlist.observe(this, Observer {
         it?.let {
             adapterList.submitList(it)
         }
     })
        val a=applicationContext as App
        activityMainBinding.swiperefresh.setOnRefreshListener{
           provider.request()
           activityMainBinding.swiperefresh.isRefreshing=false


        }







    }
}
