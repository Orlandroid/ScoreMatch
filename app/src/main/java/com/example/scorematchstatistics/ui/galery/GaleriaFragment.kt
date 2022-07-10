package com.example.scorematchstatistics.ui.galery

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.scorematchstatistics.R
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
        viewModel.getAllPlayers()
        with(binding) {
            toolbarLayout.toolbarTitle.text = "Galeria"
            toolbarLayout.toolbarBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun setUpObservers() {
        viewModel.players.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Success -> {
                    binding.recyclerGaleria.adapter = GaleriaAdapter(result.data, getListener())
                    binding.recyclerGaleria.layoutManager = GridLayoutManager(requireContext(), 2)
                    binding.progressBar2.visibility = View.INVISIBLE
                }
                is Result.Loading -> {
                    binding.progressBar2.visibility = View.VISIBLE
                }
                is Result.Error -> {
                    binding.progressBar2.visibility = View.INVISIBLE
                    val dialog = AlertDialogMessages(2, result.error)
                    activity?.let { dialog.show(it.supportFragmentManager, "alertMessage") }
                }
                is Result.EmptyList ->{
                    binding.textView.visibility=View.VISIBLE
                    binding.progressBar2.visibility = View.INVISIBLE
                }
            }
        }
        viewModel.playersByType.observe(viewLifecycleOwner){result->
            when (result) {
                is Result.Success -> {
                    binding.recyclerGaleria.adapter = GaleriaAdapter(result.data, getListener())
                    binding.recyclerGaleria.layoutManager = GridLayoutManager(requireContext(), 2)
                    binding.progressBar2.visibility = View.INVISIBLE
                }
                is Result.Loading -> {
                    binding.progressBar2.visibility = View.VISIBLE
                }
                is Result.Error -> {
                    binding.progressBar2.visibility = View.INVISIBLE
                    val dialog = AlertDialogMessages(2, result.error)
                    activity?.let { dialog.show(it.supportFragmentManager, "alertMessage") }
                }
                is Result.EmptyList ->{
                    binding.textView.visibility=View.VISIBLE
                    binding.progressBar2.visibility = View.INVISIBLE
                }
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
                viewModel.getAllPlayerByType(TYPE_NORMAL)
                return true
            }
            R.id.menu_super -> {
                viewModel.getAllPlayerByType(TYPE_SUPER)
                return true
            }
            R.id.menu_golden -> {
                Toast.makeText(requireContext(), "Golden", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.menu_all -> {
                viewModel.getAllPlayers()
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