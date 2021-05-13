package com.haikun.jetpackapp.home.ui.demo.room

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.room.Room
import com.haikun.jetpackapp.JetpackApp
import com.haikun.jetpackapp.home.R
import com.haikun.jetpackapp.home.ui.demo.room.dao.CarDao
import com.haikun.jetpackapp.home.ui.demo.room.dao.OneAndMoreDao
import com.haikun.jetpackapp.home.ui.demo.room.entity.Car
import com.haikun.jetpackapp.home.ui.demo.room.entity.ComplexEntity
import com.haikun.base_library.extension.setListener
import com.haikun.base_library.utils.LogUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

/**
 *
 * 包名：com.haikun.jetpackapp.home.ui.demo.room
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/2/8 15:26
 * 修改人：haikun
 * 修改时间：2021/2/8 15:26
 * 修改备注：
 * @version
 *
 */
class RoomFragment : Fragment(R.layout.fragment_room) {

    private val scope = Dispatchers.IO + Job()

    private var mUpdateId = 0L

    private val db: DemoDatabase by lazy {
        Room.databaseBuilder(
            JetpackApp.getContext(),
            DemoDatabase::class.java, "demo-database"
        ).build()
    }

    private val carDao: CarDao by lazy {
        db.carDao()
    }

    private val oneAndMoreDao: OneAndMoreDao by lazy {
        db.oneAndMoreDao()
    }

    private val car: LiveData<Car?> by lazy {
        carDao.queryCarAsLiveDataById(2)
    }

    private val carFlow: Flow<Car?> by lazy {
        carDao.queryCarAsFlowByIdDistinctUntilChanged(3)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button>(R.id.btn1).setOnClickListener {
            CoroutineScope(scope).launch {
                val car = Car(0, "车车", "黄色")
                val id = carDao.insertCar(car)
                LogUtil.e(id)
            }
        }

        view.findViewById<Button>(R.id.btn2).setOnClickListener {
            if (mUpdateId > 0) {
                CoroutineScope(scope).launch {
                    val car = carDao.queryCarById(mUpdateId)
                    car?.let {
                        it.name = it.name + "车"
                        carDao.updateCar(it)
                    }
                }
            }
        }

        view.findViewById<EditText>(R.id.et1).setListener {
            setAfterTextChangedCallback {
                it?.let {
                    val idStr = it.toString()
                    try {
                        mUpdateId = idStr.toLong()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }

        car.observe(viewLifecycleOwner, Observer {
            LogUtil.e(it?.toString())
        })

        CoroutineScope(scope).launch {
            carFlow.collect {
                LogUtil.e(it?.toString())
            }
        }

        view.findViewById<Button>(R.id.btn3).setOnClickListener {
            CoroutineScope(scope).launch {
                oneAndMoreDao.insertOneAndMore()
            }
        }

        view.findViewById<Button>(R.id.btn4).setOnClickListener {
            CoroutineScope(scope).launch {
                val queryOneAndMore = oneAndMoreDao.queryOneAndMore()
                LogUtil.e(queryOneAndMore.toString())
            }
        }

        view.findViewById<Button>(R.id.btn5).setOnClickListener {
            CoroutineScope(scope).launch {
                val queryOneAndMore = oneAndMoreDao.queryOneAndMore()
                val complexEntity = ComplexEntity(0, queryOneAndMore)
                oneAndMoreDao.insertComplexEntity(complexEntity)
            }
        }

        view.findViewById<Button>(R.id.btn6).setOnClickListener {
            CoroutineScope(scope).launch {
                val complexEntity = oneAndMoreDao.queryComplexEntity()
                LogUtil.e(complexEntity.toString())
            }
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}