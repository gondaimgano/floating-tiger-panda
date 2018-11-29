package com.loader.my.mymindvalleyapp.database

import android.arch.paging.DataSource
import android.arch.persistence.room.*


@Dao
interface MindItemDAO{
    @Query("Select * from minditemdata")
    fun findAll(): DataSource.Factory<Int, MindItemData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(items:List<MindItemData>)

    @Query("select * from minditemdata where itemid=:id_")
    fun find(id_:String): MindItemData

    @Delete
    fun deleteAll(items:List<MindItemData>)

}

@Database(entities = arrayOf(MindItemData::class),version = 1,exportSchema = false)
abstract class MindDatabase: RoomDatabase(){

    abstract  fun manageMindDAO(): MindItemDAO



    }
