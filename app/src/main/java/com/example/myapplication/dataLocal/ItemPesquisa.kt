package com.example.myapplication.dataLocal

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "historico_pesquisa")
data class ItemPesquisa(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nome: String
)