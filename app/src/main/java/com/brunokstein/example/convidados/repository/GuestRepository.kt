package com.brunokstein.example.convidados.repository

import android.content.Context
import com.brunokstein.example.convidados.model.GuestModel


// ESSA CLASSE E PARA MANIPULACAO DOS DADOS, JA QUE JA ESTAMOS CONECTADOS AO DATABASE.
class GuestRepository private constructor(context: Context) {

    private val guestDataBase = GuestDataBase.getDataBase(context).guestDAO()

    // Singleton - a propria classe controla o numero de instancias e acessos.
    /* companion object {
         private lateinit var repository: GuestRepository

         fun getInstance(context: Context): GuestRepository {
             if (!::repository.isInitialized) {
                 repository = GuestRepository(context)
             }
             return repository
         }
     } */

    fun insert(guest: GuestModel): Boolean {
        return guestDataBase.insert(guest) > 0
    }

    fun update(guest: GuestModel): Boolean {
        return guestDataBase.update(guest) > 0
    }

    fun delete(id: Int) { // Para deletar so precisa do ID.
        val guest = get(id)
        guestDataBase.delete(guest)
    }

    /* fun getAll(): List<GuestModel> {

        val list = mutableListOf<GuestModel>()
        try {
            val db = guestDataBase.readableDatabase

            val projection = arrayOf(
                DataBaseConstants.GUEST.COLUMNS.ID,
                DataBaseConstants.GUEST.COLUMNS.NAME,
                DataBaseConstants.GUEST.COLUMNS.PRESENCE
            )

            val cursor = db.query(
                DataBaseConstants.GUEST.TABLE_NAME, projection, null, null,
                null, null, null
            )
            // select * from guest where presence = 1 group by presence order by name (exemplo)


            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {

                    val id =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID))
                    val name =
                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
                    val presence =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE))

                    list.add(GuestModel(id, name, presence == 1))
                }

            }
            cursor.close()

        } catch (e: Exception) {
            return list
        }
        return list


    } */

    fun getAll(): List<GuestModel> {
       return guestDataBase.getAll()
    }

    fun getPresent(): List<GuestModel> {
        guestDataBase.getPresent()
    }

    fun getAbsent(): List<GuestModel> {
        guestDataBase.getAbsent()
    }

    fun get(id: Int): GuestModel {
        guestDataBase.get(id)
    }
}