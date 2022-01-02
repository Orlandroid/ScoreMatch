package com.example.scorematchstatistics.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.scorematchstatistics.databinding.ViewPagerFragmentBinding

class ViewPagerFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    private var _binding: ViewPagerFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ViewPagerFragmentBinding.inflate(inflater, container, false)
        setUpUi()
        return binding.root
    }

    private fun setUpUi() {
        with(binding) {
            val sectionsPagerAdapter = SectionsPagerAdapter(requireContext(), parentFragmentManager)
            viewPager.adapter = sectionsPagerAdapter
            tabs.setupWithViewPager(viewPager)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}