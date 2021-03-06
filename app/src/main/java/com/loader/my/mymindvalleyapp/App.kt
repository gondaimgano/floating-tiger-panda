package com.loader.my.mymindvalleyapp

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import com.android.volley.RequestQueue
import com.loader.my.mymindvalleyapp.database.MindDatabase
import com.loader.my.mymindvalleyapp.database.MindItemData
import com.loader.my.mymindvalleyapp.injector.AppModule
import com.loader.my.mymindvalleyapp.injector.DaggerGlobalShop
import javax.inject.Inject

class App : Application() {


    @Inject lateinit var datastore: MindDatabase
    @Inject lateinit var serviceAPI: RequestQueue
    @Inject lateinit var newStatus:MutableLiveData<Boolean>
    @Inject lateinit var mindItemCurrent: MindItemData

    override fun onCreate() {
        super.onCreate()
        DaggerGlobalShop.builder()
                .appModule(AppModule(this))
                                .build().inject(this)
    }


}
