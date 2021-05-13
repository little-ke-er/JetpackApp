package com.haikun.jetpackapp.data

/**
 *
 * 包名：com.haikun.jetpackapp.data
 * 类描述：网络结果处理类
 * 创建人：haikun
 * 创建时间：2021/1/15 15:04
 * 修改人：haikun
 * 修改时间：2021/1/15 15:04
 * 修改备注：
 * @version
 *
 */
sealed class Resource<T>(){
    class SuccessResource<T>(val data:T?): Resource<T>(){
        override fun toString(): String {
            return "SuccessResource(data=$data)"
        }
    }
    class ErrorResource<T>(val msg: String,val code: Int,val data:T?): Resource<T>(){
        override fun toString(): String {
            return "ErrorResource(msg='$msg', code=$code)"
        }
    }
    class LoadingResource<T>(val data:T?) : Resource<T>(){
        override fun toString(): String {
            return "LoadingResource(data=$data)"
        }
    }
}