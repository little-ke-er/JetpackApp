package com.haikun.jetpackapp.home.ui.demo.paging

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ConcatAdapter
import com.haikun.jetpackapp.home.R
import com.haikun.jetpackapp.home.databinding.FragmentPagingBinding
import com.haikun.base_library.ui.LoadAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * 包名: com.haikun.jetpackapp.home.ui.demo.databinding
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/15 10:08
 * 修改人: haikun
 * 修改时间: 2021/3/15 10:08
 * 修改备注: TODO
 */
class PagingFragment : Fragment(R.layout.fragment_paging) {


    private val pagingViewModel: PagingViewModel by viewModel()
    private val stringAdapter = StringAdapter()
    private val concatAdapter: ConcatAdapter by lazy {
        stringAdapter.withLoadStateFooter(LoadAdapter {
            stringAdapter.retry()
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dataBinding = DataBindingUtil.inflate<FragmentPagingBinding>(
            inflater,
            R.layout.fragment_paging,
            container,
            false
        )
        //使用liveData必须要设置lifecycleOwner，否则无效
        dataBinding.lifecycleOwner = viewLifecycleOwner
        dataBinding.adapter = concatAdapter

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            pagingViewModel.users.collect {
                stringAdapter.submitData(it)
            }
        }

    }

}