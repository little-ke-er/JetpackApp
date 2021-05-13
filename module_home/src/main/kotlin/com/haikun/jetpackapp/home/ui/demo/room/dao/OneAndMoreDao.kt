package com.haikun.jetpackapp.home.ui.demo.room.dao

import androidx.room.*
import com.haikun.jetpackapp.home.ui.demo.room.entity.ComplexEntity
import com.haikun.jetpackapp.home.ui.demo.room.entity.More
import com.haikun.jetpackapp.home.ui.demo.room.entity.One
import com.haikun.jetpackapp.home.ui.demo.room.entity.OneAndMore

/**
 * 包名: com.haikun.jetpackapp.home.ui.demo.room.dao
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/12 10:42
 * 修改人: haikun
 * 修改时间: 2021/3/12 10:42
 * 修改备注: TODO
 */
@Dao
abstract class OneAndMoreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertOne(one: One):Long

    @Insert
    abstract fun insertMore(more: More):Long

    @Transaction
    open fun insertOneAndMore(){
        val one = One(0, "OneName")
        val insertOneId = insertOne(one)
        val more = More(0, insertOneId, "moreName1")
        val more1 = More(0, insertOneId, "moreName2")
        insertMore(more)
        insertMore(more1)
    }

    @Transaction
    @Query("Select * from One")
    abstract fun queryOneAndMore():MutableList<OneAndMore>

    @Insert
    abstract fun insertComplexEntity(complexEntity: ComplexEntity)

    @Query("Select * from ComplexEntity")
    abstract fun queryComplexEntity():MutableList<ComplexEntity>
}