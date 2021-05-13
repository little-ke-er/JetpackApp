package com.haikun.jetpackapp.home.ui.demo.koin

/**
 * 包名: com.haikun.jetpackapp.home.ui.demo.koin
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/25 16:13
 * 修改人: haikun
 * 修改时间: 2021/3/25 16:13
 * 修改备注: TODO
 */
data class Fans(var name:String,var loveStar: SuperStar){
    override fun toString(): String {
        return "Fans(name='$name', loveStar=$loveStar)"
    }
}
