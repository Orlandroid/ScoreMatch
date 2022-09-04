package com.example.scorematchstatistics.ui.galery

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.scorematchstatistics.R
import com.example.scorematchstatistics.data.dblvelplayers.GoldenPlayersDb
import com.example.scorematchstatistics.data.dblvelplayers.GoldenPlayersDb.Companion.TYPE_GOLDEN
import com.example.scorematchstatistics.data.dblvelplayers.NormalPlayersDb.Companion.TYPE_NORMAL
import com.example.scorematchstatistics.data.dblvelplayers.SuperPlayerDb.Companion.TYPE_SUPER
import com.example.scorematchstatistics.data.state.Result
import com.example.scorematchstatistics.data.model.Player
import com.example.scorematchstatistics.databinding.FragmentGaleriaBinding
import com.example.scorematchstatistics.ui.MainActivity
import com.example.scorematchstatistics.util.AlertDialogMessages
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GaleriaFragment : Fragment(), ListerElementsGalery {


    private var _binding: FragmentGaleriaBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ViewModelGalery by viewModels()
    private var typeOfPLayer = ALL_PLAYERS
    private var isFirsTimeOnTheView = true
    private lateinit var adapter: GaleriaAdapter

    companion object {
        private const val ALL_PLAYERS = "ALL_PLAYERS"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGaleriaBinding.inflate(inflater, container, false)
        setUpUi()
        setUpObservers()
        return binding.root
    }


    private fun getListener(): ListerElementsGalery {
        return this
    }

    private fun setUpUi() {
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarLayout.myToolbar)
        adapter = GaleriaAdapter(getListener())
        binding.recyclerGaleria.adapter = adapter
        binding.recyclerGaleria.layoutManager = GridLayoutManager(requireContext(), 2)
        getAllPlayerOrByType()
        with(binding) {
            setTextToActionBar()
            toolbarLayout.toolbarBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun getAllPlayerOrByType() {
        if (isFirsTimeOnTheView) {
            isFirsTimeOnTheView = false
            viewModel.getAllPlayers()
            return
        }
        if (typeOfPLayer == ALL_PLAYERS) {
            viewModel.getAllPlayers()
            return
        }
        viewModel.getAllPlayerByType(typeOfPLayer)
    }

    @SuppressLint("SetTextI18n")
    private fun setTextToActionBar() {
        with(binding) {
            when (typeOfPLayer) {
                TYPE_NORMAL -> {
                    toolbarLayout.toolbarTitle.text = "Normal Players"
                }
                TYPE_SUPER -> {
                    toolbarLayout.toolbarTitle.text = "Super Players"
                }
                TYPE_GOLDEN -> {
                    toolbarLayout.toolbarTitle.text = "Golden Players"
                }
                else -> {
                    toolbarLayout.toolbarTitle.text = "All Players"
                }
            }
        }
    }

    private fun setUpObservers() {
        viewModel.players.observe(viewLifecycleOwner) { result ->
            binding.progressBar2.isVisible = result is Result.Loading
            binding.recyclerGaleria.isVisible = result !is Result.Loading
            when (result) {
                is Result.Success -> {
                    adapter.setData(result.data)
                }
                is Result.Error -> {
                    val dialog = AlertDialogMessages(2, result.error)
                    activity?.let { dialog.show(it.supportFragmentManager, "alertMessage") }
                }
                is Result.EmptyList -> {
                    binding.textView.visibility = View.VISIBLE
                }
                else -> {}
            }
        }
        viewModel.playersByType.observe(viewLifecycleOwner) { result ->
            binding.progressBar2.isVisible = result is Result.Loading
            binding.recyclerGaleria.isVisible = result !is Result.Loading
            when (result) {
                is Result.Success -> {
                    adapter.setData(result.data)
                }
                is Result.Error -> {
                    val dialog = AlertDialogMessages(2, result.error)
                    activity?.let { dialog.show(it.supportFragmentManager, "alertMessage") }
                }
                is Result.EmptyList -> {
                    binding.textView.visibility = View.VISIBLE
                }
                else -> {}
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_score, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_normal -> {
                typeOfPLayer = TYPE_NORMAL
                viewModel.getAllPlayerByType(TYPE_NORMAL)
                setTextToActionBar()
                return true
            }
            R.id.menu_super -> {
                typeOfPLayer = TYPE_SUPER
                viewModel.getAllPlayerByType(TYPE_SUPER)
                setTextToActionBar()
                return true
            }
            R.id.menu_golden -> {
                typeOfPLayer = TYPE_GOLDEN
                Toast.makeText(requireContext(), "Golden", Toast.LENGTH_LONG).show()
                setTextToActionBar()
                return true
            }
            R.id.menu_all -> {
                typeOfPLayer = ALL_PLAYERS
                viewModel.getAllPlayers()
                setTextToActionBar()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
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