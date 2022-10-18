package com.brunokstein.example.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.brunokstein.example.convidados.model.GuestModel
import com.brunokstein.example.convidados.repository.GuestDataBase
import com.brunokstein.example.convidados.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {
    // ViewModel nao tem contexto, quem tem e a AndroidViewModel, ai precisa de um construtor, no caso application, ele faz o papel do context.

    private val repository = GuestRepository(application)

    private val guestModel = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = guestModel

    private val _saveGuest = MutableLiveData<String>()
    val saveGuest: LiveData<String> = _saveGuest

    fun save(guest: GuestModel) {
        if (guest.id == 0){
            if (repository.insert(guest)) {
                _saveGuest.value = "Insercao com sucesso"
            }else {
                _saveGuest.value = ""
            }
        } else {
            if (repository.update(guest)) {
                _saveGuest.value = "Atualizacao com sucesso"
            }else {
                _saveGuest.value = ""
            }
        }
    }


    fun get(id: Int) {
        guestModel.value = repository.get(id)
    }
}