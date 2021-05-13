package com.haikun.jetpackapp.home.ui.demo.viewmodel

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.haikun.jetpackapp.home.R
import com.haikun.base_library.utils.LogUtil

/**
 *
 * 包名：com.haikun.jetpackapp.home.ui.demo.viewmodel
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/2/5 9:12
 * 修改人：haikun
 * 修改时间：2021/2/5 9:12
 * 修改备注：
 * @version
 *
 */
class ViewModelActivity : AppCompatActivity(R.layout.activity_view_model) {

    private val mViewModel: ActivityViewModel by viewModels()

    var s1: String = "初始化"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtil.e("onCreate")
        val tv1 = findViewById<TextView>(R.id.tv1)
        tv1.text=s1+"---"+mViewModel.s1+"---"+mViewModel.s2

        val btn1 = findViewById<Button>(R.id.btn1)
        btn1.setOnClickListener {
            mViewModel.s1="更改后的值"
            mViewModel.s2="更改后的值"
            s1="更改后的值"
            tv1.text=s1+"---"+mViewModel.s1+"---"+mViewModel.s2
        }
    }
}