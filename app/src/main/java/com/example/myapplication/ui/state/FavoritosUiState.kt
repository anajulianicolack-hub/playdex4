package com.example.myapplication.ui.state

import com.example.myapplication.data.local.entity.ItemFavorito

data class FavoritosUIState(
    val listaFavoritos: List<ItemFavorito> = emptyList(),
    val filtroSelecionado: String = "Todos",
    val adicionandoFavorito: Boolean = false,
    val favoritoSelecionado: ItemFavorito? = null,
    val resultadoBuscaId: ItemFavorito? = null
)