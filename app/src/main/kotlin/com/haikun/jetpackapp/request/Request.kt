package com.haikun.jetpackapp.request

import com.haikun.jetpackapp.data.AgResponse
import com.haikun.jetpackapp.data.Resource
import kotlinx.coroutines.flow.flow
import java.net.ConnectException
import java.net.SocketTimeoutException

/**
 *
 * 包名：com.haikun.jetpackapp.request
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/1/15 15:05
 * 修改人：haikun
 * 修改时间：2021/1/15 15:05
 * 修改备注：
 * @version
 *
 */
abstract class NetRequest<T> {

    abstract suspend fun exeApi(): AgResponse<T>

    open fun selfDeal(): Boolean = false

    open suspend fun saveToDb(data: T) {}

    open suspend fun loadFromDb(): T? {
        return null
    }

    open fun dbDataTime(): Long = 0

    fun getFlow()= flow<Resource<T>> {
        emit(Resource.LoadingResource(loadFromDb()))
        emit(exeRequest(selfDeal(), { loadFromDb() }, { saveToDb(it) }) { exeApi() })
    }

}

inline fun <T> exeRequest(
    selfDeal: Boolean = false,
    loadFromDb: () -> T? = { null },
    saveToDb: (data: T) -> Unit = {},
    api: () -> AgResponse<T>
): Resource<T> {
    try {
        val response = api()
        return if (response.code == 0) {
            if (response.data!=null){
                saveToDb(response.data)
            }
            Resource.SuccessResource(response.data)
        } else {
            if (!selfDeal) {
                //todo
            }
            Resource.ErrorResource(response.message, response.code, loadFromDb())
        }
    } catch (e: Exception) {
        e.printStackTrace()
        val msg = when (e) {
            is SocketTimeoutException -> {
                "请求超时"
            }
            is ConnectException -> {
                "网络异常"
            }
            else -> {
                "请求出错"
            }
        }
        if (!selfDeal) {
            //todo
        }
        return Resource.ErrorResource(msg, -1, loadFromDb())
    }
}