package com.haikun.base_library.extension

import android.content.res.Resources
import android.util.TypedValue

/**
 *
 * 包名：com.haikun.base_library.extension
 * 类描述：
 * 创建人：haikun
 * 创建时间：2021/2/3 10:00
 * 修改人：haikun
 * 修改时间：2021/2/3 10:00
 * 修改备注：
 * @version
 *
 */
val Float.dp: Float
    get() {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this,
            Resources.getSystem().displayMetrics
        )
    }

val Float.px: Float
    get() {
        return this / Resources.getSystem().displayMetrics.density
    }

val Int.dp: Int
    get() {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            Resources.getSystem().displayMetrics
        ).toInt()
    }

val Int.px: Int
    get() {
        return (this.toFloat() / Resources.getSystem().displayMetrics.density).toInt()
    }