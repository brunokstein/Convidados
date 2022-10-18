package com.brunokstein.example.convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.brunokstein.example.convidados.databinding.FragmentAbsentBinding
import com.brunokstein.example.convidados.viewmodel.AbsentViewModel


class AbsentFragment : Fragment() {

    private var _binding: FragmentAbsentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {
        val viewModel = ViewModelProvider(this).get(AbsentViewModel::class.java)

        _binding = FragmentAbsentBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}