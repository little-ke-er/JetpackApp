package com.haikun.jetpackapp.home.ui.demo.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig



/**
 * 包名: com.haikun.jetpackapp.home.ui.demo.paging
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/22 16:51
 * 修改人: haikun
 * 修改时间: 2021/3/22 16:51
 * 修改备注: TODO
 */
class UserRepository(private val mService: RetrofitService) {


    fun getUser()= Pager(config = PagingConfig(pageSize = 20)){
      DataPageSource(mService,"")
    }.flow
}