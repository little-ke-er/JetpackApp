package com.haikun.base_library.ui

import android.view.View

/**
 * 包名: com.haikun.base_library.ui
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/23 15:51
 * 修改人: haikun
 * 修改时间: 2021/3/23 15:51
 * 修改备注: TODO
 */
interface IAgRecyclerViewAdapter<T> {

    var onItemClickListener: OnItemClickListener<T>

    var onItemLongClickListener: OnItemLongClickListener<T>

    var onChildItemClickListener: OnItemClickListener<T>

    var onChildItemLongClickListener: OnItemLongClickListener<T>

}

typealias OnItemClickListener<T> =((View, Int, T?) -> Unit)?
typealias OnItemLongClickListener<T> = ((View, Int, T?) -> Boolean)?

fun <T> IAgRecyclerViewAdapter<T>.setOnItemClickListener(onItemClickListener: OnItemClickListener<T>){
    this.onItemClickListener=onItemClickListener
}

fun <T> IAgRecyclerViewAdapter<T>.setOnItemLongClickListener(onItemLongClickListener: OnItemLongClickListener<T>){
    this.onItemLongClickListener=onItemLongClickListener
}

fun <T> IAgRecyclerViewAdapter<T>.setOnChildItemClickListener(onChildItemClickListener: OnItemClickListener<T>){
    this.onChildItemClickListener=onChildItemClickListener
}

fun <T> IAgRecyclerViewAdapter<T>.setOnChildItemLongClickListener(onChildItemLongClickListener: OnItemLongClickListener<T>){
    this.onChildItemLongClickListener=onChildItemLongClickListener
}