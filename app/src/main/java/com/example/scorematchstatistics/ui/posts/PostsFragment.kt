package com.example.scorematchstatistics.ui.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.scorematchstatistics.R
import com.example.scorematchstatistics.data.model.ScorePostResponse
import com.example.scorematchstatistics.data.state.Result
import com.example.scorematchstatistics.databinding.FragmentPostsBinding
import com.example.scorematchstatistics.util.AlertDialogMessages
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsFragment : Fragment(), PostAdapter.ListenerClickOnPost {

    private var _binding: FragmentPostsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PostViewModel by viewModels()
    private val adapter = PostAdapter(this)
    private lateinit var skeleton: Skeleton

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
            skeleton = recyclerPosts.applySkeleton(R.layout.item_post, 4)
        }
    }

    private fun setUpObservers() {
        viewModel.posts.observe(viewLifecycleOwner) { scoreMatchResponse ->
            when (scoreMatchResponse) {
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    skeleton.showSkeleton()
                }
                is Result.Success -> {
                    skeleton.showOriginal()
                    binding.progressBar.visibility = View.GONE
                    val posts = ArrayList<ScorePostResponse.DataResponse>()
                    scoreMatchResponse.data.data.children.forEach { postResponse ->
                        if (postResponse.data.post_hint.equals("image")) {
                            posts.add(postResponse.data)
                        }
                    }
                    adapter.setData(posts = posts)
                }
                is Result.ErrorNetwork -> {
                    val dialog = AlertDialogMessages(2, scoreMatchResponse.error)
                    activity?.let { dialog.show(it.supportFragmentManager, "alertMessage") }
                    findNavController().popBackStack()
                }
                is Result.Error -> {
                    val dialog = AlertDialogMessages(2, scoreMatchResponse.error)
                    activity?.let { dialog.show(it.supportFragmentManager, "alertMessage") }
                    findNavController().popBackStack()
                }

                else -> {}
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