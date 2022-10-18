package com.brunokstein.example.convidados.repository

import androidx.room.*
import com.brunokstein.example.convidados.model.GuestModel

@Dao
interface GuestDAO {
    @Insert
    fun insert(guest: GuestModel): Long // - saber quantos dados foram inseridos.

    @Update
    fun update(guest: GuestModel): Int // - saber quantas linhas foram alteradas.

    @Delete
    fun delete(guest: GuestModel)

    @Query("SELECT * FROM Guest WHERE id = :id")
    fun get(id: Int)

    @Query("SELECT * FROM Guest")
    fun getAll(): List<GuestModel>

    @Query("SELECT * FROM Guest WHERE presence = 1")
    fun getPresent()

    @Query("SELECT * FROM Guest WHERE presence = 0")
    fun getAbsent()


}