package com.haikun.jetpackapp

import org.koin.core.module.Module

/**
 *
 * 包名：com.haikun.jetpackapp
 * 类描述：通过反射，获取在FeatureModule中定义的koin module
 * 创建人：haikun
 * 创建时间：2021/1/15 15:07
 * 修改人：haikun
 * 修改时间：2021/1/15 15:07
 * 修改备注：
 * @version
 *
 */
object KoinModuleManager {

    private const val featurePackagePrefix = BuildConfig.APPLICATION_ID


    fun getAllModules(): MutableList<Module> {

        val modules = BuildConfig.MODULE_NAMES
            .map { "$featurePackagePrefix.$it.KoinModule" }
            .map {
                Class.forName(it).kotlin.objectInstance as IKoinModule
            }.map { it.module }.toMutableList()

        modules.add(KoinModule.module)
        return modules
    }

}


interface IKoinModule{
    val module:Module
}