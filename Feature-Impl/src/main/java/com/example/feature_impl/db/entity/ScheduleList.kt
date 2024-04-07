package com.example.feature_impl.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * @author b.sabirzyanov
 */
@Entity(tableName = "ScheduleList")
data class ScheduleList(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "scheduleItemsCount")
    val scheduleItemsCount: Int,
)