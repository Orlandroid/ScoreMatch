package com.example.scorematchstatistics.ui.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.scorematchstatistics.R
import com.example.scorematchstatistics.databinding.FragmentMenuBinding


class MenuFragment : Fragment(), MenuAdapter.ListenerClickOnMenu {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    private val adapter = MenuAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        setUpUi()
        return binding.root
    }

    private fun setUpUi() {
        with(binding) {
            recyclerMenu.adapter = adapter
            recyclerMenu.layoutManager = GridLayoutManager(requireContext(), 2)
        }
        setMenu()
    }


    private fun setMenu() {
        val galery = Menu("Galeria", R.drawable.bienbenido)
        val posts = Menu("Posts", R.drawable.barreror5)
        val menus = listOf(galery, posts)
        adapter.setData(menus)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun clickOnGalery() {
        val action = MenuFragmentDirections.actionMenuFragmentToGaleriaFragment()
        findNavController().navigate(action)
    }

    override fun clickOnPost() {
        val action = MenuFragmentDirections.actionMenuFragmentToPostsFragment()
        findNavController().navigate(action)
    }

}