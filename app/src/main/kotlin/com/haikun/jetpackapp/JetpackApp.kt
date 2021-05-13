package com.haikun.jetpackapp

import android.app.Application
import android.content.Context
import com.haikun.base_library.data.DataStore
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 *
 * 包名：com.haikun.jetpackapp
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/1/15 15:07
 * 修改人：haikun
 * 修改时间：2021/1/15 15:07
 * 修改备注：
 * @version
 *
 */
class JetpackApp: Application() {

    companion object{
        lateinit var instance:JetpackApp
        fun getContext():Context{
            return instance
        }
    }



    override fun onCreate() {
        super.onCreate()
        instance=this
        initKoin()
        DataStore.init(this)
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@JetpackApp)
            modules(KoinModuleManager.getAllModules())
        }
    }
}