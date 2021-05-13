package com.haikun.jetpackapp.home.ui.demo.databinding.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import kotlin.properties.Delegates


/**
 * 包名: com.haikun.jetpackapp.home.ui.demo.databinding.view
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/17 9:19
 * 修改人: haikun
 * 修改时间: 2021/3/17 9:19
 * 修改备注: TODO
 */

@SuppressLint("SetTextI18n")
class MyButton(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatTextView(context, attrs) {

    var onTimesChangeListener: ((Int) -> Unit)? = null

    var clickTimes: Int by Delegates.observable(0) { _, _, newValue ->
        if (newValue > maxTimes) {
            if (maxTimes!=-1){
                clickTimes = maxTimes
            }
        } else if (newValue < minTimes) {
            if (minTimes!=-1){
                clickTimes = minTimes
            }
        } else {
            text = "点击了 $newValue 次"
            onTimesChangeListener?.invoke(newValue)
        }

    }

    var maxTimes: Int = -1
    private var minTimes: Int = -1


    init {
        setOnClickListener {
            if (clickTimes < maxTimes) {
                clickTimes++
            }
        }
        setOnLongClickListener {
            if (clickTimes > minTimes) {
                clickTimes--
            }
            true
        }
    }

    fun setMin(min: Int) {
        minTimes = min
    }


}