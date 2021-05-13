package com.haikun.jetpackapp.mine.ui.star

import androidx.recyclerview.widget.DiffUtil
import com.haikun.jetpackapp.mine.R
import com.haikun.jetpackapp.mine.databinding.ItemStarBinding
import com.haikun.jetpackapp.room.entity.Star
import com.haikun.base_library.ui.AgPagingDataRecyclerViewAdapter

/**
 * 包名: com.haikun.jetpackapp.mine.ui.mine
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/29 10:07
 * 修改人: haikun
 * 修改时间: 2021/3/29 10:07
 * 修改备注: TODO
 */
class StarAdapter : AgPagingDataRecyclerViewAdapter<Star, ItemStarBinding>(object :
    DiffUtil.ItemCallback<Star>() {
    override fun areItemsTheSame(oldItem: Star, newItem: Star): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Star, newItem: Star): Boolean {
        return oldItem == newItem
    }

}) {
    override fun getLayoutId(viewType: Int): Int = R.layout.item_star

    override fun bind(binding: ItemStarBinding, data: Star?, position: Int) {
        binding.data = data
    }
}