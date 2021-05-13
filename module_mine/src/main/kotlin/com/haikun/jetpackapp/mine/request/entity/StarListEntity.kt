package com.haikun.jetpackapp.mine.request.entity

import com.haikun.jetpackapp.room.entity.Star

/**
 * 包名: com.haikun.jetpackapp.mine.request.data
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/29 16:54
 * 修改人: haikun
 * 修改时间: 2021/3/29 16:54
 * 修改备注: TODO
 */
data class StarListEntity(
    val hasNext: Boolean,
    val currentPage:Int,
    val starList: List<Star>
)

