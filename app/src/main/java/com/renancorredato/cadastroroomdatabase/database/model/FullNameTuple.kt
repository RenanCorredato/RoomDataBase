package com.renancorredato.cadastroroomdatabase.database.model

import androidx.room.ColumnInfo

data class FullNameTuple(
    var id: Int,
    @ColumnInfo(name = "name") var firstName: String,
    @ColumnInfo(name = "last_name")var lastName: String,
)


