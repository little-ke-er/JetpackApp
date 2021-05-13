package com.haikun.jetpackapp.home.ui.demo.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlin.properties.Delegates


/**
 *
 * 包名：com.haikun.jetpackapp.home.ui.demo.viewmodel
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/2/5 11:20
 * 修改人：haikun
 * 修改时间：2021/2/5 11:20
 * 修改备注：
 * @version
 *
 */
class ActivityViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    var s1: String = "初始化"
    var s2: String by Delegates.observable("初始化"){_,old,new->
        saveS2(new)
    }

    init {
        readS2()
    }

    private fun readS2() {
        val value: Any? = savedStateHandle["s2"]
        if (value is String) {
            s2 = value
        }
    }

    private fun saveS2(s: String) {
        savedStateHandle["s2"] = s
    }
}