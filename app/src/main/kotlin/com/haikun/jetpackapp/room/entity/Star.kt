package com.haikun.jetpackapp.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 包名: com.haikun.jetpackapp.room.entity
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/29 10:43
 * 修改人: haikun
 * 修改时间: 2021/3/29 10:43
 * 修改备注: TODO
 */
@Entity
data class Star(
    @PrimaryKey val id: Long,
    val name: String,
    val sex: String,
    val img: String,
    val content: String,
    var currentPage:Int
)
