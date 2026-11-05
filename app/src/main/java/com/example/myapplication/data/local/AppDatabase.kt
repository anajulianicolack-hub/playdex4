package com.example.myapplication.data.local

import android.content.Context
import androidx.room3.Database
import androidx.room3.Room
import androidx.room3.RoomDatabase
import com.example.myapplication.data.local.dao.FavoritoDao
import com.example.myapplication.data.local.dao.PesquisaDAO
import com.example.myapplication.data.local.entity.ItemFavorito
import com.example.myapplication.data.local.entity.ItemPesquisa

@Database(entities = [ItemPesquisa::class, ItemFavorito::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun pesquisaDao(): PesquisaDAO
    abstract fun favoritoDao(): FavoritoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            } else {
                synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app_database"
                    ).build()
                    INSTANCE = instance
                    return instance
                }
            }
        }
    }
}