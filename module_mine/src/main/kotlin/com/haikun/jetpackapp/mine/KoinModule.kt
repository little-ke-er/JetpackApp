package com.haikun.jetpackapp.mine

import com.haikun.jetpackapp.IKoinModule
import com.haikun.jetpackapp.mine.repository.StarRepository
import com.haikun.jetpackapp.mine.ui.mine.MineViewModel
import com.haikun.jetpackapp.mine.request.StarService
import com.haikun.jetpackapp.mine.ui.star.StarViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 *
 * 包名：com.haikun.module_mine
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/1/15 16:34
 * 修改人：haikun
 * 修改时间：2021/1/15 16:34
 * 修改备注：
 * @version
 *
 */
object KoinModule : IKoinModule {
    override val module: Module = module {

        single {
            get<Retrofit>().create(StarService::class.java)
        }

        single { StarRepository(get(), get()) }

        viewModel { MineViewModel() }
        viewModel { StarViewModel(get()) }
    }

}