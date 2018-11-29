package com.loader.my.mymindvalleyapp.network

import android.arch.paging.PagedList
import com.loader.my.mymindvalleyapp.components.NetworkInterface
import com.loader.my.mymindvalleyapp.database.MindItemData

class NetworkCallback(var network: NetworkInterface): PagedList.BoundaryCallback<MindItemData>() {

    override fun onItemAtEndLoaded(itemAtEnd: MindItemData) {
        super.onItemAtEndLoaded(itemAtEnd)

    }

    override fun onZeroItemsLoaded() {
        super.onZeroItemsLoaded()

      network.request()
    }


}