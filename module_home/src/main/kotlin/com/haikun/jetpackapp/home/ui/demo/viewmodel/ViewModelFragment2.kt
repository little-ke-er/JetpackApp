package com.haikun.jetpackapp.home.ui.demo.viewmodel

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.haikun.jetpackapp.home.R

/**
 *
 * 包名：com.haikun.jetpackapp.home.ui.demo.viewmodel
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/2/5 16:02
 * 修改人：haikun
 * 修改时间：2021/2/5 16:02
 * 修改备注：
 * @version
 *
 */
class ViewModelFragment2:Fragment(R.layout.fragment_veiw_model2) {

    private val viewModel:ViewModelViewModel by viewModels()
    private val shareViewModel:ViewModelViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tv1 = view.findViewById<TextView>(R.id.tv1)
        val tv2 = view.findViewById<TextView>(R.id.tv2)

        tv1.text=viewModel.s1
        tv2.text=shareViewModel.s2

        view.findViewById<View>(R.id.btn1).setOnClickListener {
            findNavController().popBackStack()
        }
    }

}