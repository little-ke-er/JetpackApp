package com.haikun.jetpackapp.mine.ui.mine

import android.os.Bundle
import androidx.datastore.preferences.core.preferencesKey
import androidx.navigation.NavDeepLinkBuilder
import com.haikun.jetpackapp.JetpackApp
import com.haikun.jetpackapp.constant.DataStoreKey
import com.haikun.jetpackapp.constant.LiveEventBusKey
import com.haikun.jetpackapp.mine.R
import com.haikun.jetpackapp.mine.databinding.FragmentMineBinding
import com.haikun.jetpackapp.ui.base.BaseFragment
import com.haikun.jetpackapp.ui.base.addFragmentResult
import com.haikun.jetpackapp.ui.base.navigate
import com.haikun.base_library.data.DataStore
import com.haikun.base_library.utils.LogUtil
import com.jeremyliao.liveeventbus.LiveEventBus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

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
class MineFragment : BaseFragment<FragmentMineBinding, MineViewModel>(R.layout.fragment_mine) {

    override val viewModel: MineViewModel by viewModel()

    override fun bindData(viewDataBinding: FragmentMineBinding) {
        viewDataBinding.viewModel = viewModel
        viewDataBinding.clickListener = ClickListener()
    }


    override fun initData() {
        LiveEventBus.get(LiveEventBusKey.LOGIN_STATE_KET, String::class.java)
            .observe(this, {
                viewModel.readLoginState()
            })

        viewModel.readLoginState()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragmentResult()
    }

    override fun onFragmentResult(data: Bundle) {
        super.onFragmentResult(data)
        data.getString("testKey")?.let {
            LogUtil.e(it)
        }
    }


    override fun finishActivityOnBack(): Boolean {
        return true
    }

    inner class ClickListener {

        fun toLogin() {
            //findNavController().navigate(AppNavigationDirections.actionGlobalNavigationLogin())
            NavDeepLinkBuilder(JetpackApp.getContext()).setGraph(com.haikun.jetpackapp.R.navigation.app_navigation)
                .setDestination(com.haikun.jetpackapp.R.id.navigation_login).createPendingIntent()
                .send()
        }

        fun logout() {
            CoroutineScope(Dispatchers.Main).launch {
                DataStore.save(preferencesKey(DataStoreKey.USER_NAME), "")
                LiveEventBus.get(LiveEventBusKey.LOGIN_STATE_KET).post("")
            }
        }

        fun showStar() {
            navigate(MineFragmentDirections.actionMineFragmentToStarFragment())
        }
    }
}