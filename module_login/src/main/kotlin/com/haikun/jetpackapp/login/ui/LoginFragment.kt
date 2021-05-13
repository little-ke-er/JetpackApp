package com.haikun.jetpackapp.login.ui

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.haikun.jetpackapp.data.Resource
import com.haikun.jetpackapp.ui.base.BaseFragment
import com.haikun.jetpackapp.login.R
import com.haikun.jetpackapp.login.databinding.FragmentLoginBinding
import com.haikun.jetpackapp.ui.base.hideLoading
import com.haikun.jetpackapp.ui.base.showLoading
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 *
 * 包名：com.haikun.module_login.ui
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/1/15 14:51
 * 修改人：haikun
 * 修改时间：2021/1/15 14:51
 * 修改备注：
 * @version
 *
 */
class LoginFragment: BaseFragment<FragmentLoginBinding, LoginViewModel>(R.layout.fragment_login) {


    override val viewModel: LoginViewModel by viewModel()

    override fun bindData(viewDataBinding: FragmentLoginBinding) {
        viewDataBinding.loginViewModel=viewModel

        viewModel.loginResult.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.SuccessResource -> {
                    hideLoading()
                    findNavController().popBackStack()
                    viewModel.loginResult.value = null
                }
                is Resource.LoadingResource -> {
                    showLoading()
                }
                is Resource.ErrorResource -> {
                    hideLoading()
                    Toast.makeText(requireContext(),"登录失败",Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun initData() {

    }

    override fun finishActivityOnBack(): Boolean {
        return true
    }
}