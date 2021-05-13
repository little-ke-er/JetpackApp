package com.haikun.jetpackapp.home.ui.demo.databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.haikun.jetpackapp.home.R
import com.haikun.base_library.utils.LogUtil

/**
 * 包名: com.haikun.jetpackapp.home.ui.demo.databinding
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/15 14:05
 * 修改人: haikun
 * 修改时间: 2021/3/15 14:05
 * 修改备注: TODO
 */
class DataBindingViewModel : ViewModel() {

    val userName = MutableLiveData<String>()
    val clickTimes = MutableLiveData<Int>()
    val sexCheckId = MutableLiveData<Int>()
    val love = MutableLiveData<String>()


    val sex= sexCheckId.map{
        if (it== R.id.rb1){
            "男"
        }else{
            "女"
        }
    }

    init {
        userName.value = "蔡徐坤"
        love.value = "唱跳rap篮球"
        sexCheckId.value=R.id.rb2
        clickTimes.value = 10
    }

    fun save(){
        LogUtil.e("${userName.value}---${sex.value}---${love.value}")
    }

    fun reduce(){
        clickTimes.value?.let {
            clickTimes.value=it-1
        }
    }
}