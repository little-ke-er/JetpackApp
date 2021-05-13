package com.haikun.base_library.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * 包名：com.haikun.jetpackapp.home.ui.home
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/2/2 10:16
 * 修改人：haikun
 * 修改时间：2021/2/2 10:16
 * 修改备注：
 * @version
 *
 */
abstract class AgRecyclerViewAdapter<T, V : ViewDataBinding>(diffCallback: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, AgRecyclerViewHolder<V>>(diffCallback), IAgRecyclerViewAdapter<T> {

    override var onItemClickListener: OnItemClickListener<T> = null

    override var onItemLongClickListener: OnItemLongClickListener<T> = null

    override var onChildItemClickListener: OnItemClickListener<T> = null

    override var onChildItemLongClickListener: OnItemLongClickListener<T> = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgRecyclerViewHolder<V> {
        return AgRecyclerViewHolder(
            createBinding(
                parent,
                viewType
            )
        )
    }

    open fun createBinding(parent: ViewGroup, viewType: Int): V {
        return DataBindingUtil
            .inflate(
                LayoutInflater.from(parent.context),
                getLayoutId(viewType),
                parent,
                false
            )
    }

    override fun onBindViewHolder(holder: AgRecyclerViewHolder<V>, position: Int) {
        bind(holder.viewDataBinding, getItem(position), position)
        onItemClickListener?.apply {
            holder.viewDataBinding.root.setOnClickListener {
                this.invoke(it, position, getItem(position))
            }
        }

        onItemLongClickListener?.apply {
            holder.viewDataBinding.root.setOnLongClickListener {
                this.invoke(it, position, getItem(position))
            }
        }
        holder.viewDataBinding.executePendingBindings()
    }


    protected fun addChildClickListener(view: View, position: Int) {
        onChildItemClickListener?.apply {
            view.setOnClickListener {
                invoke(view, position, getItem(position))
            }
        }
    }

    protected fun addChildLongClickListener(view: View, position: Int) {
        onChildItemLongClickListener?.apply {
            view.setOnLongClickListener {
                invoke(view, position, getItem(position))
            }
        }
    }

    abstract fun getLayoutId(viewType: Int): Int

    abstract fun bind(binding: V, data: T, position: Int)

}

class AgRecyclerViewHolder<out T : ViewDataBinding>(val viewDataBinding: T) :
    RecyclerView.ViewHolder(viewDataBinding.root)



