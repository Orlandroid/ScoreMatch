package com.example.scorematchstatistics.ui.posts

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.scorematchstatistics.data.model.ScorePostResponse
import com.example.scorematchstatistics.data.state.Result
import com.example.scorematchstatistics.databinding.FragmentPostsBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList

@AndroidEntryPoint
class PostsFragment : Fragment(), PostAdapter.ListenerClickOnPost {

    private var _binding: FragmentPostsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PostViewModel by viewModels()
    private val adapter = PostAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostsBinding.inflate(layoutInflater, container, false)
        setUpUi()
        setUpObservers()
        return binding.root
    }

    private fun setUpUi() {
        viewModel.getPostScoreMatch()
        with(binding) {
            recyclerPosts.adapter = adapter
            toolbarLayout.toolbarTitle.text = "Posts"
            toolbarLayout.toolbarBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun setUpObservers() {
        viewModel.posts.observe(viewLifecycleOwner) { scoreMatchResponse ->
            when (scoreMatchResponse) {
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Result.Success -> {
                    binding.progressBar.visibility = View.GONE
                    val posts = ArrayList<ScorePostResponse.DataResponse>()
                    scoreMatchResponse.data.data.children.forEach { postResponse ->
                        if (postResponse.data.post_hint.equals("image")) {
                            posts.add(postResponse.data)
                            postResponse.data.url?.let { Log.w("ANDORID", it) }
                        }
                    }
                    adapter.setData(posts = posts)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun clickOnPost(imageUrl: String) {
        val action = PostsFragmentDirections.actionPostsFragmentToDetailImageFragment(imageUrl)
        findNavController().navigate(action)
    }

}