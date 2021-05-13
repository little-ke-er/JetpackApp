package com.haikun.base_library.ui.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * 包名：com.haikun.base_library.ui.bindingadapter
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/2/2 11:53
 * 修改人：haikun
 * 修改时间：2021/2/2 11:53
 * 修改备注：
 * @version
 *
 */

object RecyclerViewBindingAdapter {

    @BindingAdapter("android:adapter")
    @JvmStatic
    fun setAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>) {
        recyclerView.adapter=adapter
    }

}

