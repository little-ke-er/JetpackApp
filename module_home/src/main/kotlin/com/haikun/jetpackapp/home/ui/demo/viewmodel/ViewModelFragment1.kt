package com.haikun.jetpackapp.home.ui.demo.viewmodel

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.haikun.jetpackapp.home.R
import com.haikun.base_library.extension.setListener

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
class ViewModelFragment1:Fragment(R.layout.fragment_veiw_model1) {

    private val viewModel:ViewModelViewModel by viewModels()
    private val shareViewModel:ViewModelViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val et1 = view.findViewById<EditText>(R.id.et1)
        val et2 = view.findViewById<EditText>(R.id.et2)

        et1.setListener {
            setAfterTextChangedCallback {
                it?.let {
                    viewModel.s1=it.toString()
                }
            }
        }
        et2.setListener {
            setAfterTextChangedCallback {
                it?.let {
                    shareViewModel.s2=it.toString()
                }
            }
        }

        view.findViewById<View>(R.id.btn1).setOnClickListener {
            findNavController().navigate(ViewModelFragment1Directions.actionViewModelFragmentToViewModelFragment2())
        }
    }
}