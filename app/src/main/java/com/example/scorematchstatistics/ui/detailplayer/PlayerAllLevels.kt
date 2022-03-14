package com.example.scorematchstatistics.ui.detailplayer
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
            imagePlayer.setImageResource(args.player.image)
            imagePlayer.setOnClickListener {
                updateLevel()
            }
        }
    }

    private fun updateLevel() {
        viewModel.getLevelOfPlayer(level, args.player.name)
        if (level == 10) {
            level = 0
        }
    }

    private fun setFeaturesPlayer(player: Player) {
        with(binding) {
            velocidad.tvValor.text = player.speed.toString()
            altura.tvValor.text = player.height.toString()
            fuerza.tvValor.text = player.strenght.toString()
            potencia.tvValor.text = player.power.toString()
            habilidad.tvValor.text = player.skill.toString()
            respuesta.tvValor.text = player.resposne.toString()

            velocidad.imageEstadistica.setImageResource(R.drawable.running)
            altura.imageEstadistica.setImageResource(R.drawable.altura)
            fuerza.imageEstadistica.setImageResource(R.drawable.brazo)
            potencia.imageEstadistica.setImageResource(R.drawable.ball)
            habilidad.imageEstadistica.setImageResource(R.drawable.shoe)
            respuesta.imageEstadistica.setImageResource(R.drawable.thinking)

            velocidad.tvNombreEstadistica.text = "Velocidad"
            altura.tvNombreEstadistica.text = "Altura"
            fuerza.tvNombreEstadistica.text = "Fuerza"
            potencia.tvNombreEstadistica.text = "Potencia"
            habilidad.tvNombreEstadistica.text = "Habilidad"
            respuesta.tvNombreEstadistica.text = "Respuesta"

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