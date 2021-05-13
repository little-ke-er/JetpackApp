package com.haikun.jetpackapp.home.ui.demo.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.haikun.jetpackapp.home.ui.demo.room.dao.CarDao
import com.haikun.jetpackapp.home.ui.demo.room.dao.OneAndMoreDao
import com.haikun.jetpackapp.home.ui.demo.room.entity.*

/**
 * 包名: com.haikun.jetpackapp.dao.dao
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/2/25 16:36
 * 修改人: haikun
 * 修改时间: 2021/2/25 16:36
 * 修改备注: TODO
 */
@Database(entities = [Car::class,One::class, More::class, ComplexEntity::class], version = 1,exportSchema = false)
@TypeConverters(Converters::class)
abstract class DemoDatabase : RoomDatabase() {

    abstract fun carDao(): CarDao

    abstract fun oneAndMoreDao(): OneAndMoreDao
}