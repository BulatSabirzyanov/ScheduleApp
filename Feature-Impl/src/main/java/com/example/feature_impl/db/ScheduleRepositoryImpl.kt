package com.example.feature_impl.db

import com.example.feature_api.models.ScheduleApiList
import com.example.feature_api.models.ScheduleApiListItem
import com.example.feature_api.repository.ScheduleRepository
import com.example.feature_impl.db.dao.ScheduleItemDao
import com.example.feature_impl.db.dao.ScheduleListDao
import com.example.feature_impl.db.entity.ScheduleItem
import com.example.feature_impl.db.entity.ScheduleList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @author b.sabirzyanov
 */
class ScheduleRepositoryImpl @Inject constructor(
    private val scheduleListDao: ScheduleListDao,
    private val scheduleItemDao: ScheduleItemDao
) : ScheduleRepository {

    override fun getAllScheduleLists(): Flow<List<ScheduleApiList>> {
        return scheduleListDao.getAllScheduleListsWithItems().map { scheduleListWithItems ->
            scheduleListWithItems.map { scheduleListWithItem ->
                val scheduleList = scheduleListWithItem.scheduleList
                val scheduleItems = scheduleListWithItem.scheduleItems.map { scheduleItem ->
                    ScheduleApiListItem(
                        id = scheduleItem.id,
                        date = scheduleItem.date,
                        title = scheduleItem.title,
                        resolved = scheduleItem.resolved,
                        favorite = scheduleItem.favorite
                    )
                }
                ScheduleApiList(
                    id = scheduleList.id,
                    title = scheduleList.title,
                    scheduleItemsCount = scheduleList.scheduleItemsCount,
                    scheduleItems = scheduleItems
                )
            }
        }
    }

    override suspend fun createScheduleListItem(scheduleApiList: ScheduleApiList) {
        val scheduleList = ScheduleList(
            id = scheduleApiList.id,
            title = scheduleApiList.title,
            scheduleItemsCount = scheduleApiList.scheduleItems.size
        )
        scheduleListDao.insert(scheduleList)
        scheduleApiList.scheduleItems.forEach { scheduleApiListItem ->
            val scheduleItem = ScheduleItem(
                id = scheduleApiListItem.id,
                listId = scheduleList.id,
                date = scheduleApiListItem.date,
                title = scheduleApiListItem.title,
                resolved = scheduleApiListItem.resolved,
                favorite = scheduleApiListItem.favorite
            )
            scheduleItemDao.insert(scheduleItem)
        }
    }

    override suspend fun deleteScheduleListItem(scheduleApiList: ScheduleApiList) {
        scheduleListDao.deleteById(scheduleApiList.id)
    }
}