package com.haikun.jetpackapp.ui.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

/**
 *
 * 包名：com.haikun.jetpackapp.ui
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/1/14 15:46
 * 修改人：haikun
 * 修改时间：2021/1/14 15:46
 * 修改备注：
 * @version
 *
 */
interface IBaseView<V: ViewDataBinding,out M: ViewModel> {
    val viewDataBinding:V
    val viewModel:M

    fun bindData(viewDataBinding:V)
}