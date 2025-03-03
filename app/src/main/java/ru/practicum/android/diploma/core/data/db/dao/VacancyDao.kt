package ru.practicum.android.diploma.core.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.practicum.android.diploma.core.data.db.entity.VacancyEntity

@Dao
interface VacancyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVacancy(vacancy: VacancyEntity)

    @Delete
    suspend fun deleteVacancy(vacancy: VacancyEntity)

    @Query("SELECT * FROM vacancy_table")
    suspend fun getVacancyList(): List<VacancyEntity>

    @Query("SELECT * FROM vacancy_table WHERE id = :id")
    suspend fun getCurrentVacancy(id: String): VacancyEntity

    @Query("SELECT id FROM vacancy_table")
    suspend fun getListId(): List<String>
}
