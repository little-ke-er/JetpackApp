package com.haikun.jetpackapp.home.ui.demo.databinding.view

import androidx.databinding.*

/**
 * 包名: com.haikun.jetpackapp.home.ui.demo.databinding.view
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/17 15:35
 * 修改人: haikun
 * 修改时间: 2021/3/17 15:35
 * 修改备注: TODO
 */
@BindingMethods(value = [BindingMethod(type = MyButton::class, attribute = "maxTimes", method = "setMaxTimes")])
object ViewAdapter {



    @BindingAdapter("minTimes")
    @JvmStatic
    fun setMinTimes(view: MyButton, minTimes: Int) {
        view.setMin(minTimes)
    }


    @BindingAdapter("clickTimes")
    @JvmStatic
    fun setClickTimes(view: MyButton, clickTimes: Int) {
        if (view.clickTimes != clickTimes) {
            view.clickTimes = clickTimes
        }
    }

    @InverseBindingAdapter(attribute = "clickTimes")
    @JvmStatic
    fun getClickTimes(view: MyButton): Int {
        return view.clickTimes
    }


    @BindingAdapter("clickTimesAttrChanged")
    @JvmStatic
    fun setListener(view: MyButton, listener: InverseBindingListener?) {

        view.onTimesChangeListener = {
            listener?.onChange()
        }

    }

}