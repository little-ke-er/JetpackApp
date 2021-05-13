package com.haikun.jetpackapp.login.repository

import com.haikun.jetpackapp.data.AgResponse
import com.haikun.jetpackapp.data.Resource
import com.haikun.jetpackapp.request.NetRequest
import com.haikun.jetpackapp.login.request.LoginService
import com.haikun.jetpackapp.login.request.data.User
import kotlinx.coroutines.flow.Flow


/**
 *
 * 包名：com.haikun.module_login.repository
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/1/15 15:37
 * 修改人：haikun
 * 修改时间：2021/1/15 15:37
 * 修改备注：
 * @version
 *
 */
class LoginRepository(val loginService: LoginService) {

    fun login(account: String,password:String): Flow<Resource<User>> {

        return object : NetRequest<User>() {
            override suspend fun exeApi(): AgResponse<User> {
                return loginService.login(account,password)
            }
        }.getFlow()
    }

}