package com.haikun.jetpackapp.home.ui.demo.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.haikun.jetpackapp.home.ui.demo.room.entity.Car
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

/**
 * 包名: com.haikun.jetpackapp.dao.dao
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/2/25 9:31
 * 修改人: haikun
 * 修改时间: 2021/2/25 9:31
 * 修改备注: TODO
 */
@Dao
interface CarDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCar(car: Car):Long

    @Delete
    fun deleteCar(car: Car)

    @Update
    suspend fun updateCar(car: Car)

    @Query("SELECT * From Car")
    fun queryCarList(): MutableList<Car>

    @Query("Select * from Car where id=:id")
    suspend fun queryCarById(id: Long): Car?

    @Query("Select * From Car where id = :id")
    fun queryCarAsLiveDataById(id: Long): LiveData<Car?>

    @Query("Select * From Car where id = :id")
    fun queryCarAsFlowById(id: Long): Flow<Car>

    fun queryCarAsFlowByIdDistinctUntilChanged(id: Long): Flow<Car?> =
        queryCarAsFlowById(id).distinctUntilChanged()

}