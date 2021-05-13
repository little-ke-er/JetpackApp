package com.haikun.jetpackapp.home.ui.demo.koin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.haikun.jetpackapp.home.R
import com.haikun.jetpackapp.home.databinding.FragmentKoinBinding
import com.haikun.base_library.utils.LogUtil
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

/**
 * 包名: com.haikun.jetpackapp.home.ui.demo.koin
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/25 15:07
 * 修改人: haikun
 * 修改时间: 2021/3/25 15:07
 * 修改备注: TODO
 */
class KoinFragment : ScopeFragment() {

    //注入普通对象
    val wangYiBo: SuperStar by inject()
    //注入普通对象-named
    val xiaoZhan by inject<SuperStar>(named("zhanZhan"))
    //注入单例对象
    val girl: Fans by inject()
    //注入单例对象-named
    val boy: Fans by inject(named("boy"))
    //注入viewModel
    val viewModel: KoinViewModel by viewModel()
    //注入activity-viewModel
    private val activityViewModel: KoinViewModel by sharedViewModel()
    //生成作用域
    private val scope1 by lazy {
        getKoin().getOrCreateScope("作用域1", named("作用域1"))
    }
    //作用域注入
    val fans by scope1.inject<Fans>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dataBinding = DataBindingUtil.inflate<FragmentKoinBinding>(
            inflater,
            R.layout.fragment_koin,
            container,
            false
        )
        //使用liveData必须要设置lifecycleOwner，否则无效
        dataBinding.data = this

        return dataBinding.root

    }

    fun addYiBo() {
        wangYiBo.sex = "女"
        val wangYiBo1: SuperStar by inject()
        LogUtil.e(wangYiBo)
        LogUtil.e(wangYiBo1)

    }

    fun addGirl() {
        girl.name = "饭圈女人"
        val girl1: Fans by inject()
        LogUtil.e(girl1)
    }

    fun logViewModel() {
        LogUtil.e(viewModel.text)
        LogUtil.e(activityViewModel.text)
    }

    fun modifyViewModel() {
        viewModel.text = "修改后的值"

        activityViewModel.text = "修改后的值"
    }

    fun jump(){
        findNavController().navigate(KoinFragmentDirections.actionKoinFragmentToKoinFragment1())
    }
}