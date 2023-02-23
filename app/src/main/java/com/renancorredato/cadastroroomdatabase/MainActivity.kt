package com.renancorredato.cadastroroomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.renancorredato.cadastroroomdatabase.database.AppDatabase
import com.renancorredato.cadastroroomdatabase.database.dao.ClientDao
import com.renancorredato.cadastroroomdatabase.database.model.Client
import com.renancorredato.cadastroroomdatabase.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var appDatabase: AppDatabase
    private lateinit var clientDao: ClientDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        this.appDatabase = AppDatabase.getInstance(this)
        this.clientDao = appDatabase.clientDao()


        binding.btnInsert.setOnClickListener {
            insertClient()
//            insertClientAll()
        }
        binding.btnQuery.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                //  searchAllClients()
                searchById()
            }

        }

    }

    private suspend fun searchById() {
        val client = clientDao.searchById(11)
        Log.i("Renan", client.toString())
    }

    private suspend fun searchAllClients() {
        val clients = clientDao.searchAll()
        for (client in clients) {
            Log.i("Renan", client.toString())
        }
    }

    private fun insertClient() {
        CoroutineScope(Dispatchers.IO).launch {
            clientDao.insert(
                Client(
                    name = "Renan",
                    lastName = "Corredato",
                    document = "12345679",
                    city = "Suzano"
                )
            )
        }
    }

    private fun insertClientAll() {
        CoroutineScope(Dispatchers.IO).launch {
            clientDao.insertAll(
                listOf(
                    Client(
                        name = "Renan 1",
                        lastName = "Corredato",
                        document = "12345679",
                        city = "Suzano"
                    ),
                    Client(
                        name = "Renan 2",
                        lastName = "Corredato",
                        document = "12345679",
                        city = "Suzano"
                    ),
                    Client(
                        name = "Renan 3",
                        lastName = "Corredato",
                        document = "12345679",
                        city = "Suzano"
                    ),
                    Client(
                        name = "Renan 4",
                        lastName = "Corredato",
                        document = "12345679",
                        city = "Suzano"
                    ),
                )

            )
        }
    }
}