package com.example.apophischatingtest.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.apophischatingtest.domain.enitity.User

object MainDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(
        oldItem: User, newItem: User
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: User,
        newItem: User
    ): Boolean {
        return oldItem == newItem
    }
}