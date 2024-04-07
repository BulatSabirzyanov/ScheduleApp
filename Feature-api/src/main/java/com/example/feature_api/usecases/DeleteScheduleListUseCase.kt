package com.example.feature_api.usecases

import com.example.feature_api.models.ScheduleApiList
import com.example.feature_api.repository.ScheduleRepository
import javax.inject.Inject

/**
 * @author b.sabirzyanov
 */
class DeleteScheduleListUseCase @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) {
    suspend operator fun invoke(scheduleApiList: ScheduleApiList){
        scheduleRepository.deleteScheduleListItem(scheduleApiList)
    }
}