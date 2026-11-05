package com.example.myapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.local.entity.ItemPesquisa
import com.example.myapplication.data.repository.ItemPesquisaRepository
import com.example.myapplication.ui.state.PesquisaUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PesquisaViewModel(
    private val repository: ItemPesquisaRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(PesquisaUiState())
    val uiState: StateFlow<PesquisaUiState> = _uiState.asStateFlow()

    init {
        // Coleta o Flow reativo em tempo real do banco de dados
        viewModelScope.launch {
            repository.buscarPesquisas().collect { lista ->
                _uiState.update { it.copy(historico = lista) }
            }
        }
    }

    fun atualizarTexto(novoTexto: String) {
        _uiState.update { it.copy(textoPesquisa = novoTexto) }
    }

    fun adicionarPesquisa() {
        val pesquisaTrim = _uiState.value.textoPesquisa.trim()
        if (pesquisaTrim.isNotEmpty()) {
            viewModelScope.launch {
                repository.inserirPesquisa(pesquisaTrim)
                _uiState.update { it.copy(textoPesquisa = "") }
            }
        }
    }

    fun removerItem(item: ItemPesquisa) {
        viewModelScope.launch {
            repository.deletarPesquisa(item)
        }
    }
}

// Fábrica necessária para criar a ViewModel com a dependência do Repository
class PesquisaViewModelFactory(
    private val repository: ItemPesquisaRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PesquisaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PesquisaViewModel(repository) as T
        }
        throw IllegalArgumentException("Classe ViewModel desconhecida")
    }
}