package com.example.ca_1

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater

import android.content.Context
import com.example.ca_1.databinding.ListItemBinding


// Errors at the start were because TvShowEntity was a Java file instead of Kotlin
class TvShowsListAdapter(private val tvShowList: List<TvShowEntity>,
                         private val listener: ListItemListener)
    :
    RecyclerView.Adapter<TvShowsListAdapter.ViewHolder>(){
        inner class ViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView){
            // Changed to ListItemBinding
            val binding = ListItemBinding.bind(itemView)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.list_item, parent, false)
            return ViewHolder(view)
        }
        override fun getItemCount() = tvShowList.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int){
            val tvShow = tvShowList[position]
            with(holder.binding){
                // Added the tvShowName is in the list_item layout so this is recognised here
                tvShowName.text = tvShow.name
            }
        }

    // Added the ListItemListeener
    interface ListItemListener {
         fun onItemClick(tvShow: TvShowEntity)
    }
    }