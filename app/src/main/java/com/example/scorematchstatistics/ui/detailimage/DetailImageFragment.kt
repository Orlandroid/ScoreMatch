package com.example.scorematchstatistics.ui.detailimage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.scorematchstatistics.databinding.FragmentDetailImageBinding
import com.squareup.picasso.Picasso


class DetailImageFragment : Fragment() {

    private var _binding: FragmentDetailImageBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<DetailImageFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailImageBinding.inflate(layoutInflater, container, false)
        setUpUi()
        return binding.root
    }

    private fun setUpUi() {
        with(binding) {
            Picasso.get().load(args.imageUrl).into(photoView)
            toolbarLayout.toolbarTitle.text = "Detail image"
            toolbarLayout.toolbarBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }


}