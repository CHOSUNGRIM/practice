package com.example.apophischatingtest.presentation.adapter

import android.animation.Animator
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.apophischatingtest.R
import com.example.apophischatingtest.databinding.ItemChatAponymousBinding
import com.example.apophischatingtest.databinding.ItemChatUserBinding
import com.example.apophischatingtest.domain.enitity.User

abstract class ChatViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    abstract fun onBind(data: User)
}

class MainAdapter : ListAdapter<User, ChatViewHolder>(DIFF_ITEM_CALLBACK) {

    class AponymousViewHolder(
        private val binding: ItemChatAponymousBinding
    ) : ChatViewHolder(binding) {
        override fun onBind(data: User) {
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

    class UserViewHolder(
        private val binding: ItemChatUserBinding
    ) : ChatViewHolder(binding) {
        override fun onBind(data: User) {
            binding.user = data
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChatViewHolder {
        return when (viewType) {
            R.layout.item_chat_aponymous -> {
                val binding = ItemChatAponymousBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                AponymousViewHolder(binding)
            }
            else -> {
                val binding = ItemChatUserBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                UserViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).tag) {
            APONYMOUS -> R.layout.item_chat_aponymous
            else -> R.layout.item_chat_user
        }
    }


    companion object {
        const val APONYMOUS = true
        private val DIFF_ITEM_CALLBACK = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(
                oldItem: User, newItem: User
            ): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(
                oldItem: User,
                newItem: User
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

}