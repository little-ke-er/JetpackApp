package com.haikun.jetpackapp

import androidx.room.Room
import com.haikun.jetpackapp.room.AppDatabase
import com.haikun.jetpackapp.ui.base.FragmentStateViewModel
import com.haikun.jetpackapp.ui.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 *
 * 包名：com.haikun.jetpackapp
 * 类描述：App模块中的koin注入 module
 * 创建人：haikun
 * 创建时间：2021/1/15 15:13
 * 修改人：haikun
 * 修改时间：2021/1/15 15:13
 * 修改备注：
 * @version
 *
 */
object KoinModule : IKoinModule {

    override val module: Module = module {
        single {
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }

        single {
            OkHttpClient.Builder().addInterceptor(get<HttpLoggingInterceptor>())
                .build()
        }

        single {
            Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(get())
                .build()
        }

        single {
            Room.databaseBuilder(
                JetpackApp.getContext(),
                AppDatabase::class.java, "app-database"
            ).build()
        }

        single { get<AppDatabase>().starDao() }

        viewModel { FragmentStateViewModel() }

        viewModel { MainViewModel() }

    }

}