package com.haikun.jetpackapp.util

import com.squareup.moshi.Moshi

/**
 * 包名: com.haikun.jetpackapp.util
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/12 14:35
 * 修改人: haikun
 * 修改时间: 2021/3/12 14:35
 * 修改备注: TODO
 */
object MoshiInstance {

    val moshi:Moshi by lazy {
        Moshi.Builder().build()
    }
}