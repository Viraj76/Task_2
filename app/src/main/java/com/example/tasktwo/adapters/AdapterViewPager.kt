package com.example.tasktwo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tasktwo.utils.Constant
import com.example.tasktwo.databinding.IvPostBinding
import com.example.tasktwo.models.Post

class AdapterViewPager(val context : Context, val findMajorColor: (Int) -> Unit) : RecyclerView.Adapter<AdapterViewPager.PostViewHolder>() {
    class PostViewHolder(val binding : IvPostBinding) : ViewHolder(binding.root)

    val diffUtil = object : DiffUtil.ItemCallback<Post>(){
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }
    }

    val differ = AsyncListDiffer(this,diffUtil)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(IvPostBinding.inflate(LayoutInflater.from(parent.context) , parent, false))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = differ.currentList[position]

        holder.binding.apply {
            iv.setImageResource(post.image!!)
            findMajorColor(post.image)

            save.setOnClickListener { Constant.showToast(context, "Going to implement it soon!") }
            share.setOnClickListener { Constant.showToast(context, "Going to implement it soon!") }
            download.setOnClickListener {
                Constant.showToast(
                    context,
                    "Going to implement it soon!"
                )
            }

        }

    }


}