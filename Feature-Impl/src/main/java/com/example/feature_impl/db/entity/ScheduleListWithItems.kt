package com.example.feature_impl.db.entity

import androidx.room.Embedded
import androidx.room.Relation

/**
 * @author b.sabirzyanov
 */
data class ScheduleListWithItems(
    @Embedded val scheduleList: ScheduleList,
    @Relation(
        parentColumn = "id",
        entityColumn = "listId"
    )
    val scheduleItems: List<ScheduleItem>
)