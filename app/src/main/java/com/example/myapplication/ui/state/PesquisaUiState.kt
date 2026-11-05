package com.example.myapplication.ui.state

import com.example.myapplication.data.local.entity.ItemPesquisa

data class PesquisaUiState(
    val textoPesquisa: String = "",
    val historico: List<ItemPesquisa> = emptyList()
)