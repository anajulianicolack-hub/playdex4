package com.example.myapplication.data.local.dao

import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.Query
import androidx.room3.Update
import com.example.myapplication.data.local.entity.ItemPesquisa
import kotlinx.coroutines.flow.Flow

@Dao
interface PesquisaDAO {
    @Insert
    suspend fun inserir(item: ItemPesquisa)

    @Query("SELECT * FROM historico_pesquisa ORDER BY id DESC")
    fun buscarItens(): Flow<List<ItemPesquisa>>

    @Update
    suspend fun atualizarItem(item: ItemPesquisa)

    @Delete
    suspend fun removerItem(item: ItemPesquisa)
}