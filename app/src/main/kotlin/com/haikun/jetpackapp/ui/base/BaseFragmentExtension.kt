package com.haikun.jetpackapp.ui.base

import android.os.Bundle
import androidx.annotation.NonNull
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.haikun.jetpackapp.R


fun  BaseFragment<*, *>.getResultBundle(): Bundle {
    return fragmentResultViewModel.resultBundle
}

fun  BaseFragment<*, *>.addFragmentResult(){
    findNavController().addOnDestinationChangedListener(onDestinationChangedListener)
}

fun  BaseFragment<*, *>.removeFragmentResult(){
    findNavController().removeOnDestinationChangedListener(onDestinationChangedListener)
}

fun  BaseFragment<*, *>.navigate(@NonNull directions: NavDirections) {

    val navOptions = navOptions {
        anim {
            enter = R.anim.anim_fragment_in
            exit = R.anim.nav_default_exit_anim
            popExit = R.anim.anim_fragment_out
        }
    }
    findNavController().navigate(directions, navOptions)
}

fun BaseFragment<*, *>.showLoading(){
    if (!progressDialog.isShowing){
        progressDialog.show()
    }
}

fun BaseFragment<*, *>.hideLoading(){
    if (progressDialog.isShowing){
        progressDialog.dismiss()
    }
}


