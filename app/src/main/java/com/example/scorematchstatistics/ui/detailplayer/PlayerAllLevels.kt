package com.example.scorematchstatistics.ui.detailplayer
import android.os.Bundle
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
import timber.log.Timber

@AndroidEntryPoint
class PlayerAllLevels : Fragment() {

    private var _binding: FragmentPlayerAllLevelsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PlayerAllLevelViewModel by viewModels()
    private val args: PlayerAllLevelsArgs by navArgs()
    private var level = 0
    private var player:Player?=null


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
        viewModel.getLevelOfPlayer(args.player.name)
        with(binding) {
            toolbarLayout.toolbarBack.setOnClickListener {
                findNavController().popBackStack()
            }
            toolbarLayout.toolbarTitle.text=args.player.name
            imagePlayer.setImageResource(args.player.image)
            buttonBack.setOnClickListener{
                level--
                if (level==-1){
                    level=9
                }
                updateLevel()
            }
            buttonNext.setOnClickListener {
                level++
                if (level==10){
                    level=0
                }
                updateLevel()
            }
        }
    }

    private fun updateLevel(){
        val levelText = level+1
        binding.tvLevel.text=levelText.toString()
        player?.let { it1 -> setFeaturesPlayer(it1,level) }
    }



    private fun setFeaturesPlayer(player: Player,level:Int) {
        this.player=player
        with(binding) {
            velocidad.tvValor.text = player.skills[level].speed.toString()
            altura.tvValor.text = player.skills[level].height.toString()
            fuerza.tvValor.text = player.skills[level].strenght.toString()
            potencia.tvValor.text = player.skills[level].power.toString()
            habilidad.tvValor.text = player.skills[level].skill.toString()
            respuesta.tvValor.text = player.skills[level].resposne.toString()

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
                    setFeaturesPlayer(result.data,level)
                    Timber.w(result.data.skills.toString())
                }
                is Result.Loading -> {
                    this.tag?.let { Timber.tag(it).w("CARGANDO") }
                }
                is Result.Error -> {
                    val dialog = AlertDialogMessages(2,result.error)
                    activity?.let { dialog.show(it.supportFragmentManager, "alertMessage") }
                }

                else -> {}
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}