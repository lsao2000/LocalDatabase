package com.example.LocalDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medicament")
class Medicament(@PrimaryKey var nomMedicament:String, var qtite:Int)
