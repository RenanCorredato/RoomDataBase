package com.renancorredato.cadastroroomdatabase.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Client(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val lastName: String,
    val document: String,
    val city: String
)
