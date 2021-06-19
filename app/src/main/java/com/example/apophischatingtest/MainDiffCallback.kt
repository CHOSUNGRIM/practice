package com.example.apophischatingtest

import androidx.recyclerview.widget.DiffUtil

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