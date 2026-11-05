package com.example.myapplication.data.local.dao

import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.Query
import androidx.room3.Update
import com.example.myapplication.data.local.entity.ItemFavorito
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritoDao {
    @Insert
    suspend fun inserir(favorito: ItemFavorito)

    // REMOVIDO o 'suspend': Flow já é assíncrono por padrão no Room
    @Query("SELECT * FROM tabela_favoritos ORDER BY id DESC")
    fun buscarFavoritos(): Flow<List<ItemFavorito>>

    @Query("SELECT * FROM tabela_favoritos WHERE id = :id")
    suspend fun buscarPorId(id: Int): ItemFavorito?

    @Update
    suspend fun atualizarFavorito(favorito: ItemFavorito)

    @Delete
    suspend fun removerFavorito(favorito: ItemFavorito)
}