package com.haikun.jetpackapp.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.haikun.jetpackapp.JetpackApp
import com.haikun.base_library.utils.ScreenAdaptUtil

/**
 *
 * 包名：com.haikun.jetpackapp.ui
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/1/14 15:31
 * 修改人：haikun
 * 修改时间：2021/1/14 15:31
 * 修改备注：
 * @version
 *
 */
abstract class BaseActivity<V : ViewDataBinding, out M : BaseViewModel>(@LayoutRes val contentLayoutId: Int) :
    AppCompatActivity(), IBaseView<V, M> {

    override lateinit var viewDataBinding: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ScreenAdaptUtil.adaptScreen(this, JetpackApp.instance, 360f)
        viewDataBinding = DataBindingUtil.setContentView(this, contentLayoutId)
        viewDataBinding.lifecycleOwner = this
        bindData(viewDataBinding)
    }


}