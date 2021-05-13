package com.haikun.jetpackapp.login.ui

import android.text.TextUtils
import androidx.datastore.preferences.core.preferencesKey
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.haikun.jetpackapp.constant.DataStoreKey
import com.haikun.jetpackapp.data.Resource
import com.haikun.jetpackapp.login.repository.LoginRepository
import com.haikun.jetpackapp.login.request.data.User
import com.haikun.base_library.data.DataStore
import com.haikun.jetpackapp.ui.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 *
 * 包名：com.haikun.module_login.ui
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/1/15 14:54
 * 修改人：haikun
 * 修改时间：2021/1/15 14:54
 * 修改备注：
 * @version
 *
 */
class LoginViewModel(private val loginRepository: LoginRepository) : BaseViewModel() {

    val account: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()
    val loginResult: MutableLiveData<Resource<User>> = MutableLiveData()

    fun login() {

        val accountValue = account.value
        val passwordValue = password.value

        if (accountValue == null || TextUtils.isEmpty(accountValue)) {
            return
        }

        if (passwordValue == null || TextUtils.isEmpty(passwordValue)) {
            return
        }

        viewModelScope.launch {
            loginRepository.login(accountValue, passwordValue).collect {
                if (it is Resource.SuccessResource){
                    DataStore.save(preferencesKey(DataStoreKey.USER_NAME),"haikun")
                }
                loginResult.value=it
            }
        }

    }
}