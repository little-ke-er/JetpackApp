package com.haikun.jetpackapp.home.ui.demo.koin


import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * 包名: com.haikun.jetpackapp.home.ui.demo.koin
 * 文件描述: koin 模块
 * 创建人: haikun
 * 创建时间: 2021/3/25 15:29
 * 修改人: haikun
 * 修改时间: 2021/3/25 15:29
 * 修改备注: TODO
 */
object KoinModule {

    val module: Module = module {

        //普通创建
        factory { SuperStar("王一博", "男") }

        //普通创建 named为战战
        factory(named("zhanZhan")) { SuperStar("肖战", "男") }

        //单例创建
        single { Fans("饭圈女孩", get()) }

        //单例创建 named为boy
        single(named("boy")) { Fans("饭圈男孩", get(named("zhanZhan"))) }

        //用作用域创建
        scope(named("作用域1")) {
            scoped { SuperStar("蔡徐坤", "男") }
            scoped { Fans("蔡徐坤的粉丝", get()) }
        }

        //创建viewModel
        //viewModel { KoinViewModel(get(named("boy"))) }

        scope<KoinFragment> {
            //创建viewModel
            viewModel { KoinViewModel(get(named("boy"))) }
        }
    }
}