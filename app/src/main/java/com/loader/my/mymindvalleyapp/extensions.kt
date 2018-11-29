package com.loader.my.mymindvalleyapp

import com.loader.my.mymindvalleyapp.database.MindItem
import com.loader.my.mymindvalleyapp.database.MindItemData

fun MindItem.todataitem(): MindItemData {
    return MindItemData().apply {
       this.mindItem=this@todataitem

    }
}