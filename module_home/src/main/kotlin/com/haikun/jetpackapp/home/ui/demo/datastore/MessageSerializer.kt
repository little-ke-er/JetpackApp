package com.haikun.jetpackapp.home.ui.demo.datastore

import androidx.datastore.core.Serializer
import com.haikun.jetpackapp.home.ui.demo.datastore.bean.MessageEvent
import java.io.InputStream
import java.io.OutputStream

/**
 * 包名: com.haikun.jetpackapp.home.ui.demo.datastore
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/15 11:38
 * 修改人: haikun
 * 修改时间: 2021/3/15 11:38
 * 修改备注: TODO
 */
object MessageSerializer : Serializer<MessageEvent> {
    override val defaultValue: MessageEvent
        get() = MessageEvent.getDefaultInstance()

    override fun readFrom(input: InputStream): MessageEvent {
        return MessageEvent.parseFrom(input)
    }

    override fun writeTo(t: MessageEvent, output: OutputStream) {
        t.writeTo(output)
    }
}