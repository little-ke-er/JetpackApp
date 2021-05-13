package com.haikun.jetpackapp.room.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.haikun.jetpackapp.room.entity.Star

/**
 * 包名: com.haikun.jetpackapp.room.dao
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/29 10:49
 * 修改人: haikun
 * 修改时间: 2021/3/29 10:49
 * 修改备注: TODO
 */
@Dao
abstract class StarDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertStar(starList: List<Star>)

    @Query("DELETE FROM Star where id=:id")
    abstract suspend fun deleteStar(id:Long)

    @Query("select * from Star order by id")
    abstract fun queryStar(): PagingSource<Int, Star>

}