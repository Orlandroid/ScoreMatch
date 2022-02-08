package com.example.scorematchstatistics.ui.detailplayer


import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.scorematchstatistics.R
import com.example.scorematchstatistics.data.state.Result
import com.example.scorematchstatistics.data.model.Player
import com.example.scorematchstatistics.databinding.FragmentPlayerAllLevelsBinding
import com.example.scorematchstatistics.util.AlertDialogMessages
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayerAllLevels : Fragment() {

    private var _binding: FragmentPlayerAllLevelsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PlayerAllLevelViewModel by viewModels()
    private val args: PlayerAllLevelsArgs by navArgs()
    private var level = 1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayerAllLevelsBinding.inflate(inflater, container, false)
        setUpUi()
        setUpObservers()
        return binding.root
    }

    private fun setUpUi() {
        viewModel.getLevelOfPlayer(level, args.player.name)
        with(binding) {
            toolbarLayout.toolbarBack.setOnClickListener {
                findNavController().popBackStack()
            }
            toolbarLayout.toolbarTitle.text=args.player.name
            imagenPlayer.setImageResource(args.player.image)
            imagenPlayer.setOnClickListener {
                updateLevel()
            }
        }
    }

    private fun updateLevel() {
        level++
        if (level%2==0){
            binding.materialCardView.setCardBackgroundColor(resources.getColor(R.color.azul))
        }else{
            binding.materialCardView.setCardBackgroundColor(resources.getColor(R.color.primary))
        }
        viewModel.getLevelOfPlayer(level, args.player.name)
        if (level == 10) {
            level = 0
        }
    }

    private fun setFeaturesPlayer(player: Player) {
        with(binding) {
            nivel.text = player.level.toString()
            speed.text = player.speed.toString()
            heigth.text = player.height.toString()
            strength.text = player.strenght.toString()
            power.text = player.power.toString()
            skill.text = player.skill.toString()
            response.text = player.resposne.toString()
        }
    }

    private fun setUpObservers() {
        viewModel.player.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Success -> {
                    setFeaturesPlayer(result.data)
                }
                is Result.Loading -> {
                    Log.w(this.tag, "CARGANDO")
                }
                is Result.Error -> {
                    val dialog = AlertDialogMessages(2,result.error)
                    activity?.let { dialog.show(it.supportFragmentManager, "alertMessage") }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}