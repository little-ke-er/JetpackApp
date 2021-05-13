package com.haikun.jetpackapp.login.request

import com.haikun.jetpackapp.data.AgResponse
import com.haikun.jetpackapp.login.request.data.User
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 * 包名：com.haikun.module_login.request
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/1/15 15:35
 * 修改人：haikun
 * 修改时间：2021/1/15 15:35
 * 修改备注：
 * @version
 *
 */
interface LoginService {

    @GET("login")
    suspend fun login(@Query("account") account:String,@Query("password") password:String):AgResponse<User>
}