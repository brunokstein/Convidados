package com.brunokstein.example.convidados.view.viewholder

import android.content.DialogInterface
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.brunokstein.example.convidados.databinding.RowGuestBinding
import com.brunokstein.example.convidados.model.GuestModel
import com.brunokstein.example.convidados.view.listener.OnGuestListener

class GuestViewHolder(private val bind: RowGuestBinding, private val listener: OnGuestListener) :
    RecyclerView.ViewHolder(bind.root) {

    fun bind(guest: GuestModel) { // Ligacao do elemento interface com os dados
        bind.textName.text = guest.name

        bind.textName.setOnClickListener {
            listener.onClick(guest.id)
        }

        bind.textName.setOnLongClickListener {

            AlertDialog.Builder(itemView.context)
                .setTitle("Remocao de convidado")
                .setMessage("Tem certeza que deseja remover ?")
                .setPositiveButton(
                    "Sim"
                ) { dialog, which -> listener.onDelete(guest.id) } // which nao precisa ja que ta direcionado ao positive buttom.
                .setNegativeButton(
                    "Nao", null
                )
                .create()
                .show()
            true
        }


    }

}