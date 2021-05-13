package com.haikun.base_library.extension

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

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
private typealias AfterTextChangedCallback = ((s: Editable?) -> Unit)?
private typealias BeforeTextChangedCallback = ((s: CharSequence?, start: Int, count: Int, after: Int) -> Unit)?
private typealias OnTextChangedCallback = ((s: CharSequence?, start: Int, before: Int, count: Int) -> Unit)?

class EditTextWatcher : TextWatcher {

    private var afterTextChanged: AfterTextChangedCallback = null
    private var beforeTextChangedCallback: BeforeTextChangedCallback = null
    private var onTextChangedCallback: OnTextChangedCallback = null

    override fun afterTextChanged(s: Editable?) {
        afterTextChanged?.invoke(s)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        beforeTextChangedCallback?.invoke(s,start,count,after)
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        onTextChangedCallback?.invoke(s,start,before,count)
    }

    fun setAfterTextChangedCallback(afterTextChanged: AfterTextChangedCallback){
        this.afterTextChanged=afterTextChanged
    }

    fun setBeforeTextChangedCallback(beforeTextChangedCallback: BeforeTextChangedCallback){
        this.beforeTextChangedCallback=beforeTextChangedCallback
    }

    fun setOnTextChangedCallback(onTextChangedCallback: OnTextChangedCallback){
        this.onTextChangedCallback=onTextChangedCallback
    }
}

fun EditText.setListener(dsl: EditTextWatcher.() -> Unit) {
    addTextChangedListener(EditTextWatcher().apply(dsl))
}