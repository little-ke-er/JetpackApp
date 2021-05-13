package com.haikun.jetpackapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.haikun.jetpackapp.room.dao.StarDao
import com.haikun.jetpackapp.room.entity.Star

/**
 * 包名: com.haikun.jetpackapp.room
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/29 10:41
 * 修改人: haikun
 * 修改时间: 2021/3/29 10:41
 * 修改备注: TODO
 */
@Database(entities = [Star::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun starDao(): StarDao

}