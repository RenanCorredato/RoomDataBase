package com.renancorredato.cadastroroomdatabase.database.dao

import androidx.room.*
import com.renancorredato.cadastroroomdatabase.database.model.Client
import com.renancorredato.cadastroroomdatabase.database.model.FullNameTuple

@Dao
interface ClientDao {
    @Insert
    suspend fun insert(client: Client)

    @Insert
    suspend fun insertAll(client: List<Client>)

    @Query("SELECT * FROM clients;") // buscar os dados
    suspend fun searchAll(): List<Client>

    @Query("SELECT * FROM clients WHERE id = :id;")  // buscar ou consulta os dados id
    suspend fun searchById(id: Int):Client

    @Query("SELECT * FROM clients WHERE id IN (:id);")  // buscar ou consulta  de conjuntos de dados
    suspend fun searchByIdS(id: List<Int>):List<Client>

    @Query("SELECT id,name,last_name FROM clients") // buscar ou consulta  da tabelas e dados que voce deseja isso, e mas performatico
    suspend fun searchFullNames():List<FullNameTuple>

    @Update
    suspend fun update(client: Client)// atualizando os dados

    @Delete
    suspend fun delete(client: Client)

}