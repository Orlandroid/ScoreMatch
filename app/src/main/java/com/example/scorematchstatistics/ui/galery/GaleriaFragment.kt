package com.example.scorematchstatistics.ui.galery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.scorematchstatistics.R
import com.example.scorematchstatistics.databinding.FragmentGaleriaBinding


class GaleriaFragment : Fragment() {


    private lateinit var nombres: Array<String>

    private var _binding: FragmentGaleriaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGaleriaBinding.inflate(inflater, container, false)
        setUpUi()
        return binding.root
    }

    private fun setUpUi() {
        nombres = requireContext().resources.getStringArray(R.array.nombres_jugadores)
        with(binding) {
            recyclerGaleria.adapter = GaleriaAdapter(nombres, getImagenId())
            recyclerGaleria.layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}