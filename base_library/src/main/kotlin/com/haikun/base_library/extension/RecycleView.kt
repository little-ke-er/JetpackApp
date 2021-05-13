package com.haikun.base_library.extension

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

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
fun RecyclerView.setListener(dsl: RecycleViewDsl.() -> Unit) {
    val recycleViewDsl = RecycleViewDsl(this)
    dsl.invoke(recycleViewDsl)
    addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
        val gestureDetector = GestureDetector(context, recycleViewDsl)

        override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {

        }

        override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
            gestureDetector.onTouchEvent(e)
            return false
        }

        override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        }
    })
}

class RecycleViewDsl(private val recyclerView: RecyclerView) : GestureDetector.OnGestureListener {
    private var listener: ((View, Int) -> Unit)? = null
    private var longListener: ((View, Int) -> Unit)? = null
    override fun onShowPress(e: MotionEvent?) {
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        e?.let {
            recyclerView.findChildViewUnder(it.x, it.y)?.let { child ->
                listener?.invoke(child, recyclerView.getChildAdapterPosition(child))
            }
        }
        return false
    }

    override fun onDown(e: MotionEvent?): Boolean {
        return false
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        return false
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        return false
    }

    override fun onLongPress(e: MotionEvent?) {
        e?.let {
            recyclerView.findChildViewUnder(it.x, it.y)?.let { child ->
                longListener?.invoke(child, recyclerView.getChildAdapterPosition(child))
            }
        }
    }

    fun setOnItemClickListener(listener: (View, Int) -> Unit) {
        this.listener = listener
    }

    fun setOnItemLongClickListener(listener: (View, Int) -> Unit) {
        this.longListener = listener
    }
}


