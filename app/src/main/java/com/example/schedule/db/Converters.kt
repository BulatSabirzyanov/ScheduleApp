package com.example.schedule.db
import androidx.room.TypeConverter
import java.util.Date

/**
 * @author b.sabirzyanov
 */

class Converters {
    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun toDate(millisSinceEpoch: Long?): Date? {
        return millisSinceEpoch?.let { Date(it) }
    }
}