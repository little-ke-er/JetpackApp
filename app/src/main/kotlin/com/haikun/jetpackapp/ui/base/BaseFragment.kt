package com.haikun.jetpackapp.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 *
 * 包名：com.haikun.jetpackapp.ui
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/1/14 15:46
 * 修改人：haikun
 * 修改时间：2021/1/14 15:46
 * 修改备注：
 * @version
 *
 */
abstract class BaseFragment<V : ViewDataBinding, M : BaseViewModel>(@LayoutRes val contentLayoutId: Int) :
    Fragment(), IBaseView<V, M> {

    internal val fragmentResultViewModel: FragmentStateViewModel by sharedViewModel()
    override lateinit var viewDataBinding: V
    internal val progressDialog by lazy {
        ProgressDialog(requireContext())
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        if (finishActivityOnBack()) {
            requireActivity().onBackPressedDispatcher.addCallback(this) {
                requireActivity().finish()
            }
        }
        viewDataBinding = DataBindingUtil.inflate(inflater, contentLayoutId, container, false)
        viewDataBinding.lifecycleOwner = this
        bindData(viewDataBinding)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!viewModel.isInitData) {
            initData()
            viewModel.isInitData = true
        }
    }


    open fun onFragmentResult(data: Bundle) {

    }

    internal val onDestinationChangedListener by lazy {
        NavController.OnDestinationChangedListener { _, _, _ ->
            onFragmentResult(fragmentResultViewModel.resultBundle)
            fragmentResultViewModel.resultBundle.clear()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        removeFragmentResult()
        hideLoading()
    }

    abstract fun initData()

    /**
     * 按下返回按钮是否退出
     * @return Boolean
     */
    open fun finishActivityOnBack() = false
}