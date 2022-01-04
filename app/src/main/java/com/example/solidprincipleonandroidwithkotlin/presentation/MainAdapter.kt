package com.example.solidprincipleonandroidwithkotlin.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.solidprincipleonandroidwithkotlin.domain.entity.User
import com.expertsclub.solidprincipleonandroidwithkotlin.databinding.ItemUserBinding

class MainAdapter : ListAdapter<User, MainAdapter.MainViewHolder>(diffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MainViewHolder(itemBinding: ItemUserBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        private val textName = itemBinding.textName
        private val textEmail = itemBinding.textEmail

        fun bind(user: User) {
            textName.text = user.name
            textEmail.text = user.email
        }

        companion object {

            fun create(parent: ViewGroup): MainViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val itemBinding = ItemUserBinding.inflate(inflater, parent, false)
                return MainViewHolder(itemBinding)
            }
        }
    }

    companion object {
        private val diffUtilCallback = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User) = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: User, newItem: User) = oldItem == newItem
        }
    }
}
