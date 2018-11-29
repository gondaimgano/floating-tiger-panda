package com.loader.my.mymindvalleyapp.injector

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.arch.persistence.room.Room
import com.android.volley.toolbox.Volley
import com.loader.my.mymindvalleyapp.App
import com.loader.my.mymindvalleyapp.database.MindDatabase
import com.loader.my.mymindvalleyapp.database.MindItemData
import com.loader.my.mymindvalleyapp.R
import dagger.Component
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class AppModule(var app: Application){

    @Provides
    @Singleton
    fun provideApplication(): Application =app
}

@Module
class GlobalModule{
    @Provides @Singleton fun newDatabase(app:Application): MindDatabase =

            Room.databaseBuilder(app.applicationContext,
                    MindDatabase::class.java, app.applicationContext.getString(R.string.database_name)).build()

    @Singleton
    @Provides
    fun produceStatus(): MutableLiveData<Boolean> {
        return MutableLiveData<Boolean>()
    }
    @Singleton
    @Provides
    fun newItem(): MindItemData = MindItemData()


}

@Module
class NetworkModule{
    @Singleton
    @Provides
    fun newVolleyQueue(app:Application)= Volley.newRequestQueue(app.applicationContext)

}

@Component(modules = [AppModule::class, NetworkModule::class, GlobalModule::class])
@Singleton
interface GlobalShop{
    fun inject(app: App)



}