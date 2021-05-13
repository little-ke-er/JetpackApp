package com.haikun.base_library.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

/**
 *
 * 包名：com.haikun.base_library.data
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/1/18 13:54
 * 修改人：haikun
 * 修改时间：2021/1/18 13:54
 * 修改备注：
 * @version
 *
 */
object DataStore {

    private const val APP_DATA_STORE_NAME = "APP_DATA_STORE_NAME"
    private lateinit var dataStore: DataStore<Preferences>

    fun init(context: Context) {
        dataStore = context.createDataStore(APP_DATA_STORE_NAME)
    }

    suspend fun <T> save(key: Preferences.Key<T>, value: T) {
        dataStore.edit {
            it[key] = value
        }
    }

    suspend fun <T> get(key: Preferences.Key<T>): T? {
        val value = dataStore.data.map {
            it[key]
        }
        return value.first()
    }

}