package com.example.feature_api.repository

import com.example.feature_api.models.ScheduleApiList
import kotlinx.coroutines.flow.Flow

/**
 * @author b.sabirzyanov
 */
interface ScheduleRepository {

    fun getAllScheduleLists(): Flow<List<ScheduleApiList>>

    suspend fun createScheduleListItem(scheduleApiList: ScheduleApiList)

    suspend fun deleteScheduleListItem(scheduleApiList: ScheduleApiList)

}