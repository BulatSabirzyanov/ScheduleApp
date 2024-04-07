package com.example.feature_api.usecases

import com.example.feature_api.models.ScheduleApiList
import com.example.feature_api.repository.ScheduleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
/**
 * @author b.sabirzyanov
 */
class GetAllScheduleListsUseCase @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) {
    operator fun invoke(): Flow<List<ScheduleApiList>>{
        return scheduleRepository.getAllScheduleLists()
    }
}