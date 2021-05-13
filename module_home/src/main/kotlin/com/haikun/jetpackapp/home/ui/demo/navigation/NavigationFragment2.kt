package com.haikun.jetpackapp.home.ui.demo.navigation

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.haikun.jetpackapp.home.R
import com.haikun.base_library.utils.LogUtil

/**
 * 包名: com.haikun.jetpackapp.home.ui.demo.navigation
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/22 13:46
 * 修改人: haikun
 * 修改时间: 2021/3/22 13:46
 * 修改备注: TODO
 */
class NavigationFragment2: Fragment(R.layout.fragment_navigation2) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getString("testKey")?.let {
            LogUtil.e(it)
        }

        view.findViewById<Button>(R.id.btn1).setOnClickListener {
            findNavController().navigate(NavigationFragment2Directions.actionNavigationFragment2ToNavigationFragment3())
        }
    }
}