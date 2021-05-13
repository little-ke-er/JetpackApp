package com.haikun.jetpackapp.home.ui.demo.livedata

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import com.haikun.jetpackapp.home.R
import com.haikun.base_library.utils.LogUtil
import kotlinx.coroutines.*

/**
 *
 * 包名：com.haikun.jetpackapp.home.ui.demo.livedata
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/2/3 10:58
 * 修改人：haikun
 * 修改时间：2021/2/3 10:58
 * 修改备注：
 * @version
 *
 */
class LiveDataFragment : Fragment(R.layout.fragment_livedata) {

    private val normaLiveData1 = MutableLiveData<String>()
    private val normaLiveData2 = MutableLiveData<String>()
    private val transLiveData= Transformations.map(normaLiveData1){
        "$it -----转换"
    }
    private val mediatorLiveData = MediatorLiveData<String>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mediatorLiveData.addSource(normaLiveData1){
            mediatorLiveData.value="合并后的值：$it---${normaLiveData2.value}"
        }

        mediatorLiveData.addSource(normaLiveData2){
            mediatorLiveData.value="合并后的值：${normaLiveData1.value}---$it"
        }

        normaLiveData1.observe(viewLifecycleOwner, Observer {
            LogUtil.e("观察到第一个值发生了变化")
            view.findViewById<TextView>(R.id.tv1).text = it
        })

        normaLiveData2.observe(viewLifecycleOwner, Observer {
            view.findViewById<TextView>(R.id.tv2).text = it
        })

        transLiveData.observe(viewLifecycleOwner, Observer {
            view.findViewById<TextView>(R.id.tv3).text = it
        })

        mediatorLiveData.observe(viewLifecycleOwner, Observer {
            view.findViewById<TextView>(R.id.tv4).text = it
        })

        view.findViewById<Button>(R.id.btn1).setOnClickListener {
            normaLiveData1.value="LiveData1--${System.currentTimeMillis()}"
        }

        view.findViewById<Button>(R.id.btn2).setOnClickListener {
            normaLiveData2.value="LiveData2--${System.currentTimeMillis()}"
        }

        view.findViewById<Button>(R.id.btn3).setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                delay(4000)
                    normaLiveData1.postValue("LiveData1--${System.currentTimeMillis()}")
            }
        }
    }
}