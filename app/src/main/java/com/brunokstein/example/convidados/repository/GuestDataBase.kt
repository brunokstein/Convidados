package com.brunokstein.example.convidados.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.brunokstein.example.convidados.constants.DataBaseConstants
import com.brunokstein.example.convidados.model.GuestModel

// ESSA CLASSE E SO PARA CONEXAO COM O BANCO DE DADOS
//class GuestDataBase(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {

@Database(entities = [GuestModel::class], version = 1)
abstract class GuestDataBase() : RoomDatabase() {

    abstract fun guestDAO(): GuestDAO

    companion object {
        private lateinit var INSTANCE: GuestDataBase

        fun getDataBase(context: Context): GuestDataBase {
            if (!::INSTANCE.isInitialized.not()) {
                synchronized(GuestDataBase::class) { // Para evitar ser acionada por mais do que uma thread
                    INSTANCE = Room.databaseBuilder(context, GuestDataBase::class.java, "guestdb")
                        .addMigrations()
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                TODO("Not yet implemented")
            }

        }

    }

    /* companion object {
         private const val NAME = "guestdb"  // Foi criado isso para nao poder alterar.
         private const val VERSION = 1       // Igualmente o de cima.
     }
 }

     // Depois de criado, tem que ficar fazendo verificacao para ver se tal dado ja existe.
     override fun onCreate(db: SQLiteDatabase) { // Criacao do banco de dados (1, 2, 3... tabelas) - Chamado uma unica vez.
         db.execSQL(
             "CREATE TABLE " + DataBaseConstants.GUEST.TABLE_NAME + "( " +
                     DataBaseConstants.GUEST.COLUMNS.ID + "integer primary key autoincrement, " +
                     DataBaseConstants.GUEST.COLUMNS.NAME + "text, " +
                     DataBaseConstants.GUEST.COLUMNS.PRESENCE + "integer);"
         )
     }

     override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

     } */
}