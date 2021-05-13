package com.haikun.jetpackapp.home.ui.demo.paging

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 包名: com.haikun.jetpackapp.home.ui.demo.paging
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/22 16:33
 * 修改人: haikun
 * 修改时间: 2021/3/22 16:33
 * 修改备注: TODO
 */
@Entity
data class User(
    val age: Int,
    @PrimaryKey
    val name: String
) {
    override fun toString(): String {
        return "User(age=$age,  name='$name')"
    }
}

