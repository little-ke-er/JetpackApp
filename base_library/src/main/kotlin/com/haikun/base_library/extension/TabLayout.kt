package com.haikun.base_library.extension

import com.google.android.material.tabs.TabLayout

/**
 *
 * 包名：com.haikun.base_library.extension
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/2/3 9:16
 * 修改人：haikun
 * 修改时间：2021/2/3 9:16
 * 修改备注：
 * @version
 *
 */

private typealias TabCallback = ((TabLayout.Tab?) -> Unit)?

class TabLayoutOnTabSelectedListener : TabLayout.OnTabSelectedListener {

    private var onTabSelected: TabCallback = null
    private var onTabReselected: TabCallback = null
    private var onTabUnselected: TabCallback = null


    override fun onTabReselected(tab: TabLayout.Tab?) {
        onTabReselected?.invoke(tab)
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        onTabUnselected?.invoke(tab)
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        onTabSelected?.invoke(tab)
    }

    fun setOnTabSelected(onTabSelected: TabCallback) {
        this.onTabSelected = onTabSelected
    }

    fun setOnTabReselected(onTabReselected:TabCallback){
        this.onTabReselected = onTabReselected
    }

    fun setOnTabUnselected(onTabUnselected:TabCallback){
        this.onTabUnselected = onTabUnselected
    }
}

fun TabLayout.setListener(dsl: TabLayoutOnTabSelectedListener.() -> Unit) {
    addOnTabSelectedListener(TabLayoutOnTabSelectedListener().apply(dsl))
}
