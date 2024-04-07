package com.example.feature_impl.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date

/**
 * @author b.sabirzyanov
 */
@Entity(tableName = "ScheduleItem")
data class ScheduleItem(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "listId")
    val listId: String,

    @ColumnInfo(name = "date")
    val date: Date,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "resolved")
    val resolved: Boolean,

    @ColumnInfo(name = "favorite")
    val favorite: Boolean,
)
