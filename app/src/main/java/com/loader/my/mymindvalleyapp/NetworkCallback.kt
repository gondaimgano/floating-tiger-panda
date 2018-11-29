package com.loader.my.mymindvalleyapp

import android.arch.paging.PagedList

class NetworkCallback(var network: NetworkInterface): PagedList.BoundaryCallback<MindItemData>() {

    override fun onItemAtEndLoaded(itemAtEnd: MindItemData) {
        super.onItemAtEndLoaded(itemAtEnd)

    }

    override fun onZeroItemsLoaded() {
        super.onZeroItemsLoaded()

      network.request()
    }


}