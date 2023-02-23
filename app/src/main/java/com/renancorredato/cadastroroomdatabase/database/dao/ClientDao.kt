package com.renancorredato.cadastroroomdatabase.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.renancorredato.cadastroroomdatabase.database.model.Client

@Dao
interface ClientDao {
    @Insert
    suspend fun insert(client: Client)

    @Insert
    suspend fun insertAll(client: List<Client>)
}