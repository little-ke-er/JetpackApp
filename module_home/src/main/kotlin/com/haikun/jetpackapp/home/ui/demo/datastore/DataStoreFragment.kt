package com.haikun.jetpackapp.home.ui.demo.datastore

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.datastore.createDataStore
import androidx.datastore.preferences.core.preferencesKey
import androidx.fragment.app.Fragment
import com.haikun.jetpackapp.home.R
import com.haikun.base_library.data.DataStore
import com.haikun.base_library.utils.LogUtil
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.first

/**
 * 包名: com.haikun.jetpackapp.home.ui.demo.datastore
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/15 9:33
 * 修改人: haikun
 * 修改时间: 2021/3/15 9:33
 * 修改备注: TODO
 */
class DataStoreFragment : Fragment(R.layout.fragment_data_store) {


    private val scope = Dispatchers.IO + Job()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn1).setOnClickListener {
            CoroutineScope(scope).launch {
                DataStore.save(preferencesKey("key1"), "aa")
            }
        }

        view.findViewById<Button>(R.id.btn2).setOnClickListener {
            CoroutineScope(scope).launch {
                val get = DataStore.get<String>(preferencesKey("key1"))
                withContext(Dispatchers.Main) {
                    view.findViewById<TextView>(R.id.tv1).text = get
                }
            }
        }

        view.findViewById<Button>(R.id.btn3).setOnClickListener {
            CoroutineScope(scope).launch {
                val createDataStore = context?.createDataStore("data", MessageSerializer)
                createDataStore?.updateData {
                    it.toBuilder().setType(12).setMessage("消息").build()
                }
            }
        }

        view.findViewById<Button>(R.id.btn4).setOnClickListener {
            CoroutineScope(scope).launch {
                context?.createDataStore("data", MessageSerializer)?.data?.first()?.let {
                    LogUtil.e("${it.type}---${it.message}")
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}