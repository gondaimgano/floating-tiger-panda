package com.loader.my.mymindvalleyapp.adapters

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater

import android.view.ViewGroup
import com.loader.my.mymindvalleyapp.database.MindItemData

import com.loader.my.mymindvalleyapp.databinding.ItemMindBinding
import gondai.myloaderlib.MyLoader


class MyMindAdapterList(var onClick:(i: MindItemData)->Unit): PagedListAdapter<MindItemData, MyMindAdapterList.ViewHolder>(
        object : DiffUtil.ItemCallback<MindItemData>(){
            override fun areItemsTheSame(oldItem: MindItemData, newItem: MindItemData): Boolean
                    = oldItem.id==newItem.id

            override fun areContentsTheSame(oldItem: MindItemData, newItem: MindItemData): Boolean
                    =oldItem==newItem


        }
) {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemMindBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(itemBinding)
    }




    override fun onBindViewHolder(vh: ViewHolder, position: Int) {
        getItem(position)?.let{
            vh.bindTo(it)
        }

    }

    inner class ViewHolder (item:ItemMindBinding): RecyclerView.ViewHolder(item.root){
        val binding:ItemMindBinding
        init {
            binding=item
        }
        fun bindTo(data: MindItemData) {
               with(binding){
                   dataitem=data
                   MyLoader.loadImage(data.mindItem.user.profileImage.medium,binding.imageView)
                      itemView.setOnClickListener {
                          onClick(data)
                      }
                    executePendingBindings()
               }
        }

    }
}