package com.example.feature_api.models

import java.util.Date

/**
 * @author b.sabirzyanov
 */
data class ScheduleApiListItem(
    val id: String,
    val date: Date,
    val title: String,
    val resolved: Boolean,
    val favorite: Boolean
)