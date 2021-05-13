package com.haikun.base_library.ui.bindingadapter

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

/**
 * 包名: com.haikun.base_library.ui.bindingadapter
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/26 14:27
 * 修改人: haikun
 * 修改时间: 2021/3/26 14:27
 * 修改备注: TODO
 */
object ViewBindingAdapter {

    @BindingAdapter("android:isVisible")
    @JvmStatic
    fun isVisible(view: View, isVisible: Boolean) {
        view.isVisible = isVisible
    }
}