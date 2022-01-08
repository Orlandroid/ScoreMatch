package com.example.scorematchstatistics.ui.galery

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.scorematchstatistics.R
import com.example.scorematchstatistics.data.Result
import com.example.scorematchstatistics.databinding.FragmentGaleriaBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GaleriaFragment : Fragment() {



    private var _binding: FragmentGaleriaBinding? = null
    private val binding get() = _binding!!
    private val viewModel:ViewModelGalery by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGaleriaBinding.inflate(inflater, container, false)
        setUpUi()
        setUpObservers()
        return binding.root
    }

    private fun setUpUi() {

    }

    private fun setUpObservers(){
        viewModel.player.observe(viewLifecycleOwner,{
            when(it){
                is Result.Success ->{
                    binding.recyclerGaleria.adapter=GaleriaAdapter(it.data)
                    binding.recyclerGaleria.layoutManager=GridLayoutManager(requireContext(),2)
                }
                is Result.Loading ->{
                    Log.w(this.tag,"CARGANDO")
                }
                is Result.Error->{
                    Log.w(this.tag,"CARGANDO")
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}