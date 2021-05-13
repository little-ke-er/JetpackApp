package com.haikun.jetpackapp.mine.ui.star

import androidx.activity.addCallback
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.haikun.jetpackapp.mine.R
import com.haikun.jetpackapp.mine.databinding.FragmentStarBinding
import com.haikun.jetpackapp.ui.base.BaseFragment
import com.haikun.jetpackapp.ui.base.getResultBundle
import com.haikun.base_library.ui.LoadAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 *
 * 包名：com.haikun.module_mine.ui.settings
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/1/14 16:46
 * 修改人：haikun
 * 修改时间：2021/1/14 16:46
 * 修改备注：
 * @version
 *
 */
class StarFragment : BaseFragment<FragmentStarBinding, StarViewModel>(R.layout.fragment_star) {

    override val viewModel: StarViewModel by viewModel()

    private val mStarAdapter by lazy {
        StarAdapter()
    }

    private val mAdapter by lazy {
        mStarAdapter.withLoadStateFooter(LoadAdapter{
            mStarAdapter.retry()
        })
    }

    override fun bindData(viewDataBinding: FragmentStarBinding) {
        viewDataBinding.adapter = mAdapter
    }

    override fun initData() {

        viewModel.starList.observe(viewLifecycleOwner, {
            lifecycleScope.launchWhenCreated {
                mStarAdapter.submitData(it)
            }
        })

        requireActivity().onBackPressedDispatcher.addCallback(this) {
            getResultBundle().putString("testKey","testValue")
            findNavController().popBackStack()
        }
    }

}