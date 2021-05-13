package com.haikun.jetpackapp.mine.request

import com.haikun.jetpackapp.data.AgResponse
import com.haikun.jetpackapp.mine.request.entity.StarListEntity
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 包名: com.haikun.jetpackapp.mine.request
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/29 15:27
 * 修改人: haikun
 * 修改时间: 2021/3/29 15:27
 * 修改备注: TODO
 */
interface StarService {

    @GET("starList")
    suspend fun starList(@Query("page") page: Int): AgResponse<StarListEntity>
}