package com.example.myapplication.dataLocal

import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.Query
import androidx.room3.Update
import com.example.myapplication.dataLocal.ItemPesquisa

@Dao
interface PesquisaDAO {
    @Insert
    fun inserir(item: ItemPesquisa)

    @Query("SELECT * FROM historico_pesquisa ORDER BY id DESC")
    fun buscarItens(): List<ItemPesquisa>

    @Update
    fun atualizarItem(item: ItemPesquisa)

    @Delete
    fun removerItem(item: ItemPesquisa)
}