package com.haikun.jetpackapp.home.ui.demo.room.entity

import androidx.room.*
import com.haikun.jetpackapp.util.MoshiInstance
import com.squareup.moshi.Types

/**
 * 包名: com.haikun.jetpackapp.home.ui.demo.room.entity
 * 文件描述: TODO
 * 创建人: haikun
 * 创建时间: 2021/3/12 10:34
 * 修改人: haikun
 * 修改时间: 2021/3/12 10:34
 * 修改备注: TODO
 */
@Entity
data class One(@PrimaryKey(autoGenerate = true) val id: Long, val name: String){
    override fun toString(): String {
        return "One(id=$id, name='$name')"
    }
}

@Entity
data class More(@PrimaryKey(autoGenerate = true) val id: Long, val oneId: Long, val name: String){
    override fun toString(): String {
        return "More(id=$id, oneId=$oneId, name='$name')"
    }
}

data class OneAndMore(
    @Embedded val one: One,
    @Relation(
        parentColumn = "id",
        entityColumn = "oneId"
    ) val moreList: MutableList<More>
){
    override fun toString(): String {
        return "OneAndMore(one=$one, moreList=$moreList)"
    }
}


@Entity
data class ComplexEntity(
    @PrimaryKey val id: Long,
    val list: MutableList<OneAndMore>
){
    override fun toString(): String {
        return "ComplexEntity(id=$id, list=$list)"
    }
}


class Converters {
    @TypeConverter
    fun fromJson(value: String): MutableList<OneAndMore>? {
        val types =
            Types.newParameterizedType(MutableList::class.java, OneAndMore::class.java)
        return MoshiInstance.moshi.adapter<MutableList<OneAndMore>>(types).fromJson(value)
    }

    @TypeConverter
    fun toJson(list: MutableList<OneAndMore>): String {
        val types =
            Types.newParameterizedType(MutableList::class.java, OneAndMore::class.java)
        return MoshiInstance.moshi.adapter<MutableList<OneAndMore>>(types).toJson(list)
    }
}