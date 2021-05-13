package com.haikun.jetpackapp.home.ui.home

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.haikun.jetpackapp.home.R
import com.haikun.jetpackapp.home.databinding.FragmentHomeBinding
import com.haikun.jetpackapp.home.ui.demo.koin.KoinModule
import com.haikun.jetpackapp.ui.base.BaseFragment
import com.haikun.base_library.ui.setOnItemClickListener
import org.koin.core.context.loadKoinModules

/**
 *
 * 包名：com.haikun.module_home.ui.home
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/1/14 16:00
 * 修改人：haikun
 * 修改时间：2021/1/14 16:00
 * 修改备注：
 * @version
 */
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {


    override val viewModel: HomeViewModel by viewModels()
    private val mHomeAdapter: HomeAdapter by lazy {
        HomeAdapter().apply {
            setOnItemClickListener { view, i, data ->
                when (data) {
                    "Navigation" -> {
                        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToNavigationActivity())
                    }
                    "Lifecycle" -> {
                        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToLifecycleFragment())
                    }
                    "LiveData" -> {
                        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToLiveDataFragment())
                    }
                    "ViewModel" -> {
                        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToViewModelActivity())
                    }
                    "Flow" -> {
                        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToFlowFragment())
                    }
                    "Room" -> {
                        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToRoomFragment())
                    }
                    "DataStore" -> {
                        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDataStoreFragment())
                    }
                    "Paging" -> {
                        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToPagingFragment())
                    }
                    "DataBinding" -> {
                        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDataBindingFragment())
                    }
                    "Koin" -> {
                        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToKoinFragment())
                    }
                    else -> {
                        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToComposeActivity())
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(KoinModule.module)
    }

    override fun bindData(viewDataBinding: FragmentHomeBinding) {


        viewDataBinding.viewModel = viewModel
        viewDataBinding.adapter = mHomeAdapter
    }

    override fun initData() {

        mHomeAdapter.submitList(
            mutableListOf(
                "Navigation",
                "Lifecycle",
                "LiveData",
                "ViewModel",
                "Flow",
                "Room",
                "DataBinding",
                "Koin",
                "DataStore",
                "Paging",
                "Compose",
            )
        )

    }

    override fun finishActivityOnBack(): Boolean {
        return true
    }

}