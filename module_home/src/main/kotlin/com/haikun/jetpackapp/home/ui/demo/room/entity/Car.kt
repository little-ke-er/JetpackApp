package com.haikun.jetpackapp.home.ui.demo.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 包名: com.haikun.jetpackapp.dao.data
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/2/25 9:28
 * 修改人: haikun
 * 修改时间: 2021/2/25 9:28
 * 修改备注: TODO
 */
@Entity
data class Car(
    @PrimaryKey(autoGenerate = true) val id: Long,
    var name: String,

    val color: String,
) {
    override fun toString(): String {
        return "Car(id=$id, name='$name', color='$color')"
    }
}
