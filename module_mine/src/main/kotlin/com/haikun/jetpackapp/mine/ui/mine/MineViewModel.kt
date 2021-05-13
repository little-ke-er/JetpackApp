package com.haikun.jetpackapp.mine.ui.mine

import androidx.datastore.preferences.core.preferencesKey
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.haikun.jetpackapp.constant.DataStoreKey
import com.haikun.base_library.data.DataStore
import com.haikun.jetpackapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch

/**
 *
 * 包名：com.haikun.module_mine.ui.mine
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/1/14 16:46
 * 修改人：haikun
 * 修改时间：2021/1/14 16:46
 * 修改备注：
 * @version
 *
 */
class MineViewModel: BaseViewModel() {
    val showLoginBtn = MutableLiveData<Boolean>()

    fun readLoginState(){
        viewModelScope.launch {
            val userName = DataStore.get<String>(preferencesKey(DataStoreKey.USER_NAME))
            showLoginBtn.value= userName.isNullOrEmpty()
        }
    }
}