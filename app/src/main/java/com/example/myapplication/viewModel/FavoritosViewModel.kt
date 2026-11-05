package com.example.myapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.local.entity.ItemFavorito
import com.example.myapplication.data.repository.ItemFavoritoRepository
import com.example.myapplication.ui.state.FavoritosUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoritosViewModel(private val repository: ItemFavoritoRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(FavoritosUIState())
    val uiState: StateFlow<FavoritosUIState> = _uiState.asStateFlow()

    init {
        // Coleta o Flow reativo continuamente do Room
        viewModelScope.launch {
            repository.buscarTodosFavoritos().collect { lista ->
                _uiState.update { it.copy(listaFavoritos = lista) }
            }
        }
    }

    fun setFiltro(filtro: String) {
        _uiState.update { it.copy(filtroSelecionado = filtro) }
    }

    fun abrirAdicionar() {
        _uiState.update { it.copy(adicionandoFavorito = true) }
    }

    fun fecharAdicionar() {
        _uiState.update { it.copy(adicionandoFavorito = false) }
    }

    fun selecionarFavoritoPorId(id: Int?) {
        if (id == null) {
            _uiState.update { it.copy(favoritoSelecionado = null) }
            return
        }

        viewModelScope.launch {
            val itemDoBanco = repository.buscarPorId(id)
            _uiState.update { it.copy(favoritoSelecionado = itemDoBanco) }
        }
    }

    fun adicionar(nome: String, status: String, data: String, nota: Int, review: String) {
        val novoItem = ItemFavorito(
            title = nome,
            status = status,
            review = review,
            nota = nota,
            data = data
        )

        viewModelScope.launch {
            repository.inserirFavorito(novoItem)
            _uiState.update {
                it.copy(
                    filtroSelecionado = "Todos",
                    adicionandoFavorito = false
                )
            }
        }
    }

    fun atualizar(itemAtual: ItemFavorito, novoNome: String, novoStatus: String, novaNota: Int, novaData: String, novaReview: String) {
        val itemAtualizado = itemAtual.copy(
            title = novoNome,
            status = novoStatus,
            nota = novaNota,
            data = novaData,
            review = novaReview
        )

        viewModelScope.launch {
            repository.atualizarFavorito(itemAtualizado)
            _uiState.update { it.copy(favoritoSelecionado = itemAtualizado) }
        }
    }

    fun remover(item: ItemFavorito) {
        viewModelScope.launch {
            repository.deletarFavorito(item)
            _uiState.update {
                if (it.favoritoSelecionado?.id == item.id) {
                    it.copy(favoritoSelecionado = null)
                } else {
                    it
                }
            }
        }
    }

    fun buscarFavoritoPorId(id: Int) {
        viewModelScope.launch {
            val resultado = repository.buscarPorId(id)
            _uiState.update { it.copy(resultadoBuscaId = resultado) }
        }
    }
}

// Fábrica necessária para instanciar o ViewModel com o Repository
class FavoritosViewModelFactory(
    private val repository: ItemFavoritoRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoritosViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FavoritosViewModel(repository) as T
        }
        throw IllegalArgumentException("Classe ViewModel desconhecida")
    }
}