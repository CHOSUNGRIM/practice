package com.example.apophischatingtest.presentation.adapter

import android.animation.Animator
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.apophischatingtest.R
import com.example.apophischatingtest.domain.enitity.User
import com.example.apophischatingtest.databinding.ItemChatAponymousBinding
import com.example.apophischatingtest.databinding.ItemChatUserBinding

class MainAdapter : androidx.recyclerview.widget.ListAdapter<User, ViewHolder>(MainDiffCallback) {

    fun initData(data: MutableList<User>) {
        submitList(data)
    }

    companion object {
        const val APONYMOUS = true
        const val USER = false
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        when (viewType) {
            R.layout.item_chat_aponymous -> {
                val binding = ItemChatAponymousBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
                return AponymousViewHolder(binding)
            }
            else -> {
                val binding = ItemChatUserBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
                return UserViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is AponymousViewHolder) {
            holder.onBind(getItem(position))
        }
        else if (holder is UserViewHolder) {
            holder.onBind(getItem(position))
        }
    }

    fun addChat(user : MutableList<User>) {
        submitList(user)
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).tag) {
            APONYMOUS -> R.layout.item_chat_aponymous
            else -> R.layout.item_chat_user
        }
    }
    class AponymousViewHolder(val binding: ItemChatAponymousBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: User) {
            binding.user = data
            binding.sixthLottieShutter.addAnimatorListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                    binding.sixthLottieShutter.bringToFront()
                    binding.apoChatCv.visibility = INVISIBLE
                    binding.imgChatLeftTail.visibility = INVISIBLE
                }

                override fun onAnimationEnd(animation: Animator) {
                    binding.sixthLottieShutter.visibility = GONE
                    binding.apoChatCv.visibility = VISIBLE
                    binding.imgChatLeftTail.visibility = VISIBLE
                }

                override fun onAnimationCancel(animation: Animator) {
                }

                override fun onAnimationRepeat(animation: Animator) {
                }
            })
        }
    }
    class UserViewHolder(val binding: ItemChatUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: User) {
            binding.user = data
        }
    }
    override fun submitList(list: List<User>?) { // submitList가 안될 때를 위해 override
        super.submitList(list?.let { ArrayList(it) })
    }
}