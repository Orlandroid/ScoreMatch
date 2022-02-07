package com.example.scorematchstatistics.ui.posts

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.scorematchstatistics.data.model.ScorePostResponse
import com.example.scorematchstatistics.databinding.ItemPostBinding
import com.squareup.picasso.Picasso
import java.util.ArrayList


class PostAdapter() :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {


    private var listOfPost = listOf<ScorePostResponse.DataResponse>()

    fun setData(posts: List<ScorePostResponse.DataResponse>) {
        listOfPost = posts
        notifyDataSetChanged()
    }


    class ViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: ScorePostResponse.DataResponse) {
            with(binding) {
                Picasso.get().load(post.url).into(imagePost)
                txtNombrePublicacion.text = post.title
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val binding = ItemPostBinding.inflate(layoutInflater)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(listOfPost[position])
    }


    override fun getItemCount() = listOfPost.size
}
