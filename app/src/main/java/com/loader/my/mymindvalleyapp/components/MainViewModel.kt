package com.loader.my.mymindvalleyapp.components

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.android.volley.toolbox.JsonArrayRequest
import com.loader.my.mymindvalleyapp.*
import com.loader.my.mymindvalleyapp.database.MindItem
import com.loader.my.mymindvalleyapp.database.MindItemData
import com.loader.my.mymindvalleyapp.database.ProfileImage
import com.loader.my.mymindvalleyapp.database.User
import com.loader.my.mymindvalleyapp.network.NetworkCallback
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

interface NetworkInterface{
    fun request()
}

class MainViewModel(app:Application):AndroidViewModel(app), NetworkInterface,CoroutineScope {

var itemlist: LiveData<PagedList<MindItemData>>
var callback: NetworkCallback
    var app_: App

  var job=Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main+job
    init {
        app_=   app.applicationContext as App
        callback= NetworkCallback(this)
        val config= PagedList.Config.Builder()
                .setPageSize(MindUtil.OFFSET)
                .setInitialLoadSizeHint(10)
                .setPrefetchDistance(MindUtil.OFFSET)
                .build()


       itemlist= LivePagedListBuilder(app_.datastore.manageMindDAO().findAll(),config)
                .setBoundaryCallback(callback)
                .build()
    }
    override fun onCleared() {
        super.onCleared()
        job.cancel()
        itemlist.removeObserver {  }

    }

  override  fun request(){

    val request=JsonArrayRequest(MindUtil.baseUrl,{
        var list= mutableListOf<MindItem>()
       for(i in 0 until it.length()-1){
           list.add(MindItem().apply {
               with(it.getJSONObject(i)) {
                   id =this.getString("id")

                   createdAt=this.getString("created_at")

                   width=this.getInt("width")

                   height=this.getInt("height")

                 color=this.getString("color")

                   likes=this.getInt("likes")

                   likedByUser=this.getBoolean("liked_by_user")
                   val obj=this.getJSONObject("user")
                      val prof=obj.getJSONObject("profile_image")
                       user= User().apply {
                           name=obj.getString("name")
                           username=obj.getString("username")
                           id=obj.getString("id")
                           profileImage= ProfileImage().apply {
                               small=prof.getString("small")
                               medium=prof.getString("medium")
                               large=prof.getString("large")
                           }
                       }


               }
           })
       }
        saveItem(list)
    },{
          request()
    })

      app_.serviceAPI.add(request)


    }

    fun saveItem(item:List<MindItem>){


        this.launch {
            withContext(Dispatchers.IO){
                app_.datastore.manageMindDAO().deleteAll(
                        item.map {
                            it.todataitem()
                        }
                )
            }

            withContext(Dispatchers.IO){

                app_.datastore.manageMindDAO().insertAll(
                      item.map {
                         it.todataitem()
                      }
                )
            }
        }
    }
}