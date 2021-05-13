package com.haikun.jetpackapp.home.ui.demo.flow

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.haikun.jetpackapp.home.R
import com.haikun.base_library.utils.LogUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 *
 * 包名：com.haikun.jetpackapp.home.ui.demo.flow
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/2/8 10:02
 * 修改人：haikun
 * 修改时间：2021/2/8 10:02
 * 修改备注：
 * @version
 *
 */
class FlowFragment : Fragment(R.layout.fragment_flow) {

    /**
     * https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/
     * */

    private val scope=CoroutineScope(Dispatchers.Main)

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn1).setOnClickListener {
            scope.launch {
                testFlow()
            }
        }

        view.findViewById<Button>(R.id.btn2).setOnClickListener {
            scope.launch {
                testFlowOf()
            }
        }

        view.findViewById<Button>(R.id.btn3).setOnClickListener {
            scope.launch {
                testAsFlow()
            }
        }

        view.findViewById<Button>(R.id.btn4).setOnClickListener {
            scope.launch {
                testChannelFlow()
            }
        }

        view.findViewById<Button>(R.id.btn5).setOnClickListener {
            scope.launch {
                testTake()
            }
        }
        view.findViewById<Button>(R.id.btn6).setOnClickListener {
            scope.launch {
                testMap()
            }
        }
        view.findViewById<Button>(R.id.btn7).setOnClickListener {
            scope.launch {
                testTransform()
            }
        }
        view.findViewById<Button>(R.id.btn8).setOnClickListener {
            scope.launch {
                testFilter()
            }
        }
        view.findViewById<Button>(R.id.btn9).setOnClickListener {
            scope.launch {
                testReduce()
            }
        }
        view.findViewById<Button>(R.id.btn10).setOnClickListener {
            scope.launch {
                testZip()
            }
        }
        view.findViewById<Button>(R.id.btn11).setOnClickListener {
            scope.launch {
                testCombine()
            }
        }
        view.findViewById<Button>(R.id.btn12).setOnClickListener {
            scope.launch {
                testCatch()
            }
        }

        view.findViewById<Button>(R.id.btn14).setOnClickListener {
            scope.launch {
                testFlowOn()
            }
        }
        view.findViewById<Button>(R.id.btn15).setOnClickListener {
            testAsLiveData()
        }

    }

    private suspend fun testFlow() {
        val flow = flow<String> {
            emit("value1")
            emit("value2")
            delay(1000)
            emit("value3")
        }

        flow.collect {
            LogUtil.e(it)
        }
    }

    private suspend fun testFlowOf() {
        flowOf("value").collect {
            LogUtil.e(it)
        }

        flowOf(1, 2, 3).collect {
            LogUtil.e(it)
        }
    }

    private suspend fun testAsFlow() {

        listOf(1, 2, 3).asFlow().collect {
            LogUtil.e(it)
        }
    }


    @ExperimentalCoroutinesApi
    private suspend fun testChannelFlow() {

        //这样和flow有一定的区别，这里生产和收集是异步的，生产delay1000,不会阻塞收集
        channelFlow {
            listOf(1, 2, 3).map {
                send(it)
                delay(1000)
            }
        }.collect {
            delay(1000)
            LogUtil.e(it)
        }
    }


    private suspend fun testTake() {
        flowOf(1, 2, 3).take(2).collect {
            LogUtil.e(it)
        }
    }

    private suspend fun testMap() {
        flowOf(1, 2, 3).map {
            "第$it 个"
        }.collect {
            LogUtil.e(it)
        }
    }

    private suspend fun testTransform() {
        flowOf(1, 2, 3).transform<Int, String> {
            emit("第一次发送$it")
            emit("第二次发送$it")
        }.collect {
            LogUtil.e(it)
        }
    }

    private suspend fun testFilter() {
        flowOf(1, 2, 3).filter {
            it > 1
        }.collect {
            LogUtil.e(it)
        }
    }

    private suspend fun testReduce() {
        val result = flowOf(1, 2, 3).reduce { accumulator, value ->
            accumulator + value
        }
        LogUtil.e(result)
    }

    private suspend fun testZip() {
        val flow1 = flowOf(1, 2, 3, 4, 5)
        val flow2 = flowOf("一", "二", "三", "四", "五", "六")
        flow1.zip(flow2) { a, b ->
            "$a---$b"
        }.collect {
            LogUtil.e(it)
        }
    }

    private suspend fun testCombine() {
        val flow1 = flowOf(1, 2, 3, 4, 5).onEach { delay(1000) }
        val flow2 = flowOf("一", "二", "三", "四", "五", "六").onEach { delay(500) }
        flow1.combine(flow2) { a, b ->
            "$a---$b"
        }.collect {
            LogUtil.e(it)
        }
    }

    private suspend fun testCatch() {
        flow {
            emit(1)
            emit(1 / 0)
            emit(2)
        }.catch {
            it.printStackTrace()
        }.collect {
            LogUtil.e(it)
        }
    }



    private suspend fun testFlowOn() {
        lifecycleScope.launch {
            withContext(Dispatchers.IO){
                flowOf(1, 2, 3, 4).onEach {
                    LogUtil.e("init---${Thread.currentThread().name}")
                }.filter {
                    LogUtil.e("filter---${Thread.currentThread().name}")
                    it > 1
                }.flowOn(Dispatchers.Main).map {
                    LogUtil.e("map---${Thread.currentThread().name}")
                    "第$it"
                }.flowOn(Dispatchers.IO).map {
                    LogUtil.e("第二次map---${Thread.currentThread().name}")
                    "$it 个结果"
                }.flowOn(Dispatchers.Main).collect {
                    LogUtil.e("collect---${Thread.currentThread().name}")
                    LogUtil.e(it)
                }
            }
        }

    }


    private fun testAsLiveData() {
        flowOf(1, 2, 3, 4).asLiveData().observe(viewLifecycleOwner, Observer {
            LogUtil.e(it)
        })
    }


}