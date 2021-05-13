package com.haikun.jetpackapp.mine.ui.star

import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.haikun.jetpackapp.mine.repository.StarRepository
import com.haikun.jetpackapp.ui.base.BaseViewModel

/**
 *
 * 包名：com.haikun.module_mine.ui.settings
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/1/14 16:48
 * 修改人：haikun
 * 修改时间：2021/1/14 16:48
 * 修改备注：
 * @version
 *
 */
class StarViewModel(
    starRepository: StarRepository
) : BaseViewModel() {

    val starList = starRepository.getStarList().cachedIn(viewModelScope).asLiveData()
}