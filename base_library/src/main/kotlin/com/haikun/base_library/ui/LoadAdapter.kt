package com.haikun.base_library.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.haikun.base_library.R

class LoadAdapter(val retry:()->Unit) : LoadStateAdapter<LoadHolder>() {

    override fun onBindViewHolder(holder: LoadHolder, loadState: LoadState) {
        holder.pb.isVisible =loadState is LoadState.Loading
        holder.btn1.isVisible =loadState is LoadState.Error
        holder.btn1.setOnClickListener {
            retry()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadHolder {
        return LoadHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.load_item, parent, false)
        )
    }

}

class LoadHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val btn1: Button = itemView.findViewById(R.id.btn1)
    val pb: ProgressBar = itemView.findViewById(R.id.pb)
}