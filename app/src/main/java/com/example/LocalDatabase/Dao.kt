package com.example.LocalDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface Dao {
    @Insert
    fun addMedecament(medicament: Medicament)

    @Query("SELECT * FROM Medicament WHERE nomMedicament = :nomMed")
    suspend fun getMedecament(nomMed: String): Medicament?

    @Update
    suspend fun updateMedecament(med: Medicament)

}