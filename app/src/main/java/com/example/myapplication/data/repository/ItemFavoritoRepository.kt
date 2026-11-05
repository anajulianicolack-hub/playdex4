package com.example.myapplication.data.repository

import android.util.Log
import com.example.myapplication.data.local.dao.FavoritoDao
import com.example.myapplication.data.local.entity.ItemFavorito
import kotlinx.coroutines.flow.Flow

class ItemFavoritoRepository(private val favoritoDao: FavoritoDao) {

    fun buscarTodosFavoritos(): Flow<List<ItemFavorito>> = favoritoDao.buscarFavoritos()

    suspend fun buscarPorId(id: Int): ItemFavorito? = favoritoDao.buscarPorId(id)

    suspend fun inserirFavorito(item: ItemFavorito) {
        try {
            favoritoDao.inserir(item)
        } catch (e: Exception) {
            Log.e("Erro ao adicionar", "Msg: ${e.message}")
        }
    }

    suspend fun atualizarFavorito(item: ItemFavorito) {
        try {
            favoritoDao.atualizarFavorito(item)
        } catch (e: Exception) {
            Log.e("Erro ao atualizar", "Msg: ${e.message}")
        }
    }

    suspend fun deletarFavorito(item: ItemFavorito) {
        try {
            favoritoDao.removerFavorito(item)
        } catch (e: Exception) {
            Log.e("Erro ao deletar", "Msg: ${e.message}")
        }
    }
}