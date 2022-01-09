package com.example.scorematchstatistics.ui.galery

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.scorematchstatistics.data.Result
import com.example.scorematchstatistics.data.model.Player
import com.example.scorematchstatistics.databinding.FragmentGaleriaBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GaleriaFragment : Fragment() ,ListerElementsGalery{



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

    private fun getListener():ListerElementsGalery{
        return this
    }

    private fun setUpUi() {
        viewModel.getAllPlayers()
    }

    private fun setUpObservers(){
        viewModel.players.observe(viewLifecycleOwner,{
            when(it){
                is Result.Success ->{
                    binding.recyclerGaleria.adapter=GaleriaAdapter(it.data,getListener())
                    binding.recyclerGaleria.layoutManager=GridLayoutManager(requireContext(),2)
                    binding.progressBar2.visibility=View.INVISIBLE
                }
                is Result.Loading ->{
                    binding.progressBar2.visibility=View.VISIBLE
                }
                is Result.Error->{
                    binding.progressBar2.visibility=View.INVISIBLE
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun clickOnPlayer(player: Player) {
        val action = GaleriaFragmentDirections.actionGaleriaFragmentToPlayerAllLevels(player)
        findNavController().navigate(action)
    }


}