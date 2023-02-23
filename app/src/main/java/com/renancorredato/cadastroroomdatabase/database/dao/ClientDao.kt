package com.renancorredato.cadastroroomdatabase.database.dao

import androidx.room.*
import com.renancorredato.cadastroroomdatabase.database.model.Client

@Dao
interface ClientDao {
    @Insert
    suspend fun insert(client: Client)

    @Insert
    suspend fun insertAll(client: List<Client>)

    @Query("SELECT * FROM Client;") // buscar os dados
    suspend fun searchAll(): List<Client>

    @Query("SELECT * FROM Client WHERE id = :id;")
    suspend fun searchById(id: Int):Client

    @Update
    suspend fun update(client: Client)

    @Delete
    suspend fun delete(client: Client)

}