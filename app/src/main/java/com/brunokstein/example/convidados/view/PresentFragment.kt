package com.brunokstein.example.convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.brunokstein.example.convidados.databinding.FragmentPresentBinding
import com.brunokstein.example.convidados.viewmodel.PresentViewModel

class PresentFragment : Fragment() {

    private var _binding: FragmentPresentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {
        val viewModel = ViewModelProvider(this).get(PresentViewModel::class.java)

        _binding = FragmentPresentBinding.inflate(inflater, container, false)
       return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}