package com.haikun.jetpackapp.mine.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.haikun.jetpackapp.mine.request.StarService
import com.haikun.jetpackapp.room.dao.StarDao

/**
 * 包名: com.haikun.jetpackapp.mine.repository
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/29 15:31
 * 修改人: haikun
 * 修改时间: 2021/3/29 15:31
 * 修改备注: TODO
 */
class StarRepository(private val starService: StarService,private val starDao: StarDao) {

    fun getStarList()= Pager(config = PagingConfig(pageSize = 5),remoteMediator= StarDataPageSource(starService,"",starDao)){
        starDao.queryStar()
    }.flow
}