package com.haikun.jetpackapp.mine.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.haikun.jetpackapp.data.Resource
import com.haikun.jetpackapp.mine.request.StarService
import com.haikun.jetpackapp.request.exeRequest
import com.haikun.jetpackapp.room.dao.StarDao
import com.haikun.jetpackapp.room.entity.Star

@OptIn(ExperimentalPagingApi::class)
class StarDataPageSource(
    private val starService: StarService,
    val query: String,
    private val starDao: StarDao
) : RemoteMediator<Int, Star>() {

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Star>): MediatorResult {

        try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 0
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val last = state.lastItemOrNull() ?: return MediatorResult.Success(endOfPaginationReached = true)
                    last.currentPage+1
                }
            }
            val resource = exeRequest {
                starService.starList(loadKey)
            }

            if (resource is Resource.SuccessResource) {
                resource.data?.let {
                    starDao.insertStar(it.starList.map { star ->
                        star.currentPage = it.currentPage
                        star
                    })
                    return MediatorResult.Success(endOfPaginationReached = !it.hasNext)
                }

            }
            return MediatorResult.Error(java.lang.Exception("错误"))
        } catch (e: Exception) {
            e.printStackTrace()
            return MediatorResult.Error(e)
        }
    }


}
