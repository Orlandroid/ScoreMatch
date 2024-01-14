package com.example.scorematchstatistics.ui.posts

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.scorematchstatistics.data.model.ScorePostResponse
import com.example.scorematchstatistics.databinding.ItemPostBinding
import com.squareup.picasso.Picasso

class PostAdapter(private val listener:ListenerClickOnPost) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {


    private var listOfPost = listOf<ScorePostResponse.DataResponse>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(posts: List<ScorePostResponse.DataResponse>) {
        listOfPost = posts
        notifyDataSetChanged()
    }

    interface ListenerClickOnPost{
        fun clickOnPost(imageUrl:String)
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
        viewHolder.itemView.setOnClickListener {
            listOfPost[position].url?.let { it1 -> listener.clickOnPost(it1) }
        }
    }


    override fun getItemCount() = listOfPost.size
}
