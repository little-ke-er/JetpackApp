package com.haikun.jetpackapp.home.ui.demo.databinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.haikun.jetpackapp.home.R
import com.haikun.jetpackapp.home.databinding.FragmentDataBindingBinding
import com.haikun.base_library.utils.LogUtil

/**
 * 包名: com.haikun.jetpackapp.home.ui.demo.databinding
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/15 10:08
 * 修改人: haikun
 * 修改时间: 2021/3/15 10:08
 * 修改备注: TODO
 */
class DataBindingFragment : Fragment() {

    private val mViewModel: DataBindingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dataBinding = DataBindingUtil.inflate<FragmentDataBindingBinding>(
            inflater,
            R.layout.fragment_data_binding,
            container,
            false
        )
        //使用liveData必须要设置lifecycleOwner，否则无效
        dataBinding.lifecycleOwner = viewLifecycleOwner
        dataBinding.viewModel = mViewModel
        mViewModel.sex.observe(viewLifecycleOwner,{
            LogUtil.e(it)
        })
        return dataBinding.root

    }
}