package com.haikun.base_library.utils

import android.app.Activity
import android.app.Application
import android.content.ComponentCallbacks
import android.content.res.Configuration

/**
 * 包名: com.haikun.base_library.utils
 * 文件描述: 屏幕适配工具
 * 创建人: haikun
 * 创建时间: 2021/3/29 14:17
 * 修改人: haikun
 * 修改时间: 2021/3/29 14:17
 * 修改备注: TODO
 */
object ScreenAdaptUtil {

    private var sDensity = 0f
    private var sScaledDensity = 0f


    /**
     *
     * @param activity Activity?
     * @param application Application?
     * @param targetWithDp Int UI设计文档db
     * @return Unit
     */
    fun adaptScreen(activity: Activity, application: Application, targetWithDp: Float) {
        val applicationDisplayMetrics = application.resources.displayMetrics
        if (sDensity == 0f) {
            applicationDisplayMetrics?.apply {
                sDensity = density
                sScaledDensity = scaledDensity
                application.unregisterComponentCallbacks(object : ComponentCallbacks {
                    override fun onConfigurationChanged(newConfig: Configuration) {
                        if (newConfig.fontScale > 0) {
                            sScaledDensity = application.resources.displayMetrics.scaledDensity
                        }
                    }

                    override fun onLowMemory() {

                    }
                })
            }
        }

        if (sDensity != 0f) {
            applicationDisplayMetrics.apply {
                val targetDensity = widthPixels / targetWithDp
                val targetScaledDensity = targetDensity * (sScaledDensity / sDensity)
                val targetDensityDpi = (160 * targetDensity).toInt()

                density = targetDensity
                scaledDensity = targetScaledDensity
                densityDpi = targetDensityDpi

                activity.resources.displayMetrics.apply {
                    density = targetDensity
                    scaledDensity = targetScaledDensity
                    densityDpi = targetDensityDpi
                }
            }



        }

    }

}