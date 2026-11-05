package com.example.myapplication.data.repository

import android.util.Log
import com.example.myapplication.data.local.entity.ItemPesquisa
import com.example.myapplication.data.local.dao.PesquisaDAO
import kotlinx.coroutines.flow.Flow

class ItemPesquisaRepository(private val pesquisaDao: PesquisaDAO) {

    fun buscarPesquisas(): Flow<List<ItemPesquisa>> = pesquisaDao.buscarItens()

    suspend fun inserirPesquisa(nome: String) {
        try {
            pesquisaDao.inserir(ItemPesquisa(id = 0, nome = nome))
        } catch (e: Exception) {
            Log.e("Erro ao adicionar", "Msg: ${e.message}")
        }
    }

    suspend fun deletarPesquisa(item: ItemPesquisa) {
        try {
            pesquisaDao.removerItem(item)
        } catch (e: Exception) {
            Log.e("Erro ao deletar", "Msg: ${e.message}")
        }
    }
}