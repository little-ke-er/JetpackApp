package com.haikun.jetpackapp.home

import com.haikun.jetpackapp.IKoinModule
import com.haikun.jetpackapp.home.ui.demo.paging.PagingViewModel
import com.haikun.jetpackapp.home.ui.demo.paging.RetrofitService
import com.haikun.jetpackapp.home.ui.demo.paging.UserRepository
import com.haikun.jetpackapp.home.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 *
 * 包名：com.haikun.module_home
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/1/15 16:33
 * 修改人：haikun
 * 修改时间：2021/1/15 16:33
 * 修改备注：
 * @version
 *
 */
object KoinModule : IKoinModule {

    override val module: Module = module {
        viewModel { HomeViewModel() }

        viewModel { PagingViewModel(get()) }

        single { UserRepository(get()) }

        single {
            get<Retrofit>().create(RetrofitService::class.java)
        }

    }

}