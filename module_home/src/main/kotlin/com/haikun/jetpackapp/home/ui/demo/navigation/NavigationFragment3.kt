package com.haikun.jetpackapp.home.ui.demo.navigation

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.haikun.jetpackapp.home.R

/**
 * 包名: com.haikun.jetpackapp.home.ui.demo.navigation
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/22 13:46
 * 修改人: haikun
 * 修改时间: 2021/3/22 13:46
 * 修改备注: TODO
 */
class NavigationFragment3: Fragment(R.layout.fragment_navigation3) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn1).setOnClickListener {
            findNavController().navigate(NavigationFragment3Directions.actionNavigationFragment3ToNavigationFragment1())
        }

    }
}