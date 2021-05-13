package com.haikun.jetpackapp.home.ui.demo.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn

/**
 * 包名: com.haikun.jetpackapp.home.ui.demo.paging
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/22 16:44
 * 修改人: haikun
 * 修改时间: 2021/3/22 16:44
 * 修改备注: TODO
 */
class PagingViewModel(userRepository: UserRepository): ViewModel() {

    val users=userRepository.getUser().cachedIn(viewModelScope)
}