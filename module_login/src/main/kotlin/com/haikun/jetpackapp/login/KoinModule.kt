package com.haikun.jetpackapp.login

import com.haikun.jetpackapp.IKoinModule
import com.haikun.jetpackapp.login.repository.LoginRepository
import com.haikun.jetpackapp.login.request.LoginService
import com.haikun.jetpackapp.login.ui.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 *
 * 包名：com.haikun.module_login
 * 类描述：login模块下的 Koin注入 module
 * 创建人：haikun
 * 创建时间：2021/1/15 15:30
 * 修改人：haikun
 * 修改时间：2021/1/15 15:30
 * 修改备注：
 * @version
 *
 */
object KoinModule : IKoinModule {

    override val module: Module = module {

        single {
            get<Retrofit>().create(LoginService::class.java)
        }

        single { LoginRepository(get()) }

        viewModel { LoginViewModel(get()) }

    }

}