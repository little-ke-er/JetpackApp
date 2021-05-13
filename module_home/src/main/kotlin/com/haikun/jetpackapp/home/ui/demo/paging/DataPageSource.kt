package com.haikun.jetpackapp.home.ui.demo.paging

import androidx.paging.*
import com.haikun.jetpackapp.data.Resource
import com.haikun.jetpackapp.request.exeRequest

/**
 * 包名: com.haikun.jetpackapp.home.ui.demo.paging
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/22 16:51
 * 修改人: haikun
 * 修改时间: 2021/3/22 16:51
 * 修改备注: TODO
 */
class DataPageSource(
    private val mService: RetrofitService,
    val query: String,
) :
    PagingSource<Int, User>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        val key = params.key ?: 0

        val resource = exeRequest {
            mService.getUser(key)
        }
        return if (resource is Resource.SuccessResource) {
            resource.data?.let {
                return LoadResult.Page(
                    it, null, if (key > 8) {
                        null
                    } else {
                        key + 1
                    }
                )
            }
            LoadResult.Error(Exception())
        } else {
            LoadResult.Error(Exception())
        }
    }
}


