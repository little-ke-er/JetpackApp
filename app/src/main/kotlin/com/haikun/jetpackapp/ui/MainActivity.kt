package com.haikun.jetpackapp.ui

import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.haikun.jetpackapp.R
import com.haikun.jetpackapp.databinding.ActivityMainBinding
import com.haikun.jetpackapp.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 *
 * 包名：com.haikun.jetpackapp.ui
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/1/14 15:31
 * 修改人：haikun
 * 修改时间：2021/1/14 15:31
 * 修改备注：
 * @version
 *
 */
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    override val viewModel: MainViewModel by viewModel()
    private val navController by lazy {
        findNavController(R.id.navHostFragment)
    }
    override fun bindData(viewDataBinding: ActivityMainBinding) {
        viewDataBinding.viewModel = viewModel

        viewDataBinding.navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener(listener)
    }

    private val listener =
        NavController.OnDestinationChangedListener { controller, destination, arguments ->
            viewModel.showBottom.value =
                (destination.label == getString(
                    R.string.title_module_home
                )) || (destination.label == getString(
                    R.string.title_module_mine
                ))

        }

    override fun onDestroy() {
        super.onDestroy()
        navController.removeOnDestinationChangedListener(listener)
    }
}

