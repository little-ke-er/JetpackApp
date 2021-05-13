package com.haikun.jetpackapp.data

/**
 *
 * 包名：com.haikun.jetpackapp.data
 * 类描述：后端返回结果包装类
 * 创建人：haikun
 * 创建时间：2021/1/15 15:02
 * 修改人：haikun
 * 修改时间：2021/1/15 15:02
 * 修改备注：
 * @version
 *
 */
data class AgResponse<T>(val data:T?, val code:Int, val message:String)