package com.haikun.jetpackapp.home.ui.demo.lifecycle

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.haikun.jetpackapp.home.R
import com.haikun.base_library.utils.LogUtil
import kotlinx.coroutines.*

/**
 *
 * 包名：com.haikun.jetpackapp.home.ui.demo.lifecycle
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/2/3 10:49
 * 修改人：haikun
 * 修改时间：2021/2/3 10:49
 * 修改备注：
 * @version
 *
 */
class LifecycleFragment : Fragment(R.layout.fragment_lifecycle) {

    private val scope = Dispatchers.Default + Job()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(MyLifecycleObserver(lifecycle))
    }

    override fun onStart() {
        super.onStart()

        CoroutineScope(scope).launch {
            delay(3000)
            LogUtil.e("普通方式开启定位")
        }
    }

    override fun onStop() {
        super.onStop()
        LogUtil.e("普通方式关闭定位")
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

    inner class MyLifecycleObserver(val lifecycle: Lifecycle) : LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        fun onStart() {
            CoroutineScope(scope).launch {
                delay(3000)
                if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                    LogUtil.e("开启定位")
                }
            }
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        fun onStop() {
            LogUtil.e("关闭定位")
        }
    }
}

