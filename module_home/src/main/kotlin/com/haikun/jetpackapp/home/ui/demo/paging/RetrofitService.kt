package com.haikun.jetpackapp.home.ui.demo.paging

import com.haikun.jetpackapp.data.AgResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 包名: com.haikun.jetpackapp.home.ui.demo.paging
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/22 17:00
 * 修改人: haikun
 * 修改时间: 2021/3/22 17:00
 * 修改备注: TODO
 */
interface RetrofitService{
    @GET("getUser")
    suspend fun getUser(@Query("page")page:Int):AgResponse<List<User>>
}