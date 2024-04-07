package com.example.feature_api.models

/**
 * @author b.sabirzyanov
 */
data class ScheduleApiList(
    val id: String,
    val title: String,
    val scheduleItemsCount: Int,
    val scheduleItems: List<ScheduleApiListItem>
)