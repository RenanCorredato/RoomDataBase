package com.renancorredato.cadastroroomdatabase.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "clients")
data class Client(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    @ColumnInfo(name = "last_name")
    val lastName: String,
    val document: String,
    val city: String
){
    @Ignore // iguinora o campo na tabela
    val hasSale: Boolean = false
}
