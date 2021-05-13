package com.haikun.jetpackapp.home.ui.demo.koin

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.haikun.jetpackapp.home.R
import com.haikun.base_library.utils.LogUtil
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * 包名: com.haikun.jetpackapp.home.ui.demo.koin
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/26 10:24
 * 修改人: haikun
 * 修改时间: 2021/3/26 10:24
 * 修改备注: TODO
 */
class KoinFragment1: Fragment(R.layout.fragment_koin1) {

    //当前作用域不存在这个依赖，所以注入会出错
    val viewModel: KoinViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LogUtil.e(viewModel)
    }
}