package com.loader.my.mymindvalleyapp

fun MindItem.todataitem():MindItemData{
    return MindItemData().apply {
       this.mindItem=this@todataitem

    }
}