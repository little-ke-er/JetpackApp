package com.haikun.jetpackapp.home.ui.home

import androidx.recyclerview.widget.DiffUtil
import com.haikun.jetpackapp.home.R
import com.haikun.jetpackapp.home.databinding.ItemHomeBinding
import com.haikun.base_library.ui.AgRecyclerViewAdapter

/**
 *
 * 包名：com.haikun.jetpackapp.home.ui.home
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/2/2 10:41
 * 修改人：haikun
 * 修改时间：2021/2/2 10:41
 * 修改备注：
 * @version
 *
 */
class HomeAdapter : AgRecyclerViewAdapter<String, ItemHomeBinding>(object :
    DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

}) {


    override fun bind(
        binding: ItemHomeBinding,
        data: String,
        position: Int
    ) {
        binding.text = data
        addChildClickListener(binding.tvText,position)
        addChildLongClickListener(binding.tvText,position)
    }



    override fun getLayoutId(viewType: Int): Int = R.layout.item_home


}