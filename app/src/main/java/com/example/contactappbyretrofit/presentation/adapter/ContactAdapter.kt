package com.example.contactappbyretrofit.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.contactappbyretrofit.data.remote.response.ContactData
import com.example.contactappbyretrofit.databinding.ItemSwipeBinding

class ContactAdapter : ListAdapter<ContactData, ContactAdapter.ContactViewHolder>(ContactDiffUtil) {
    lateinit var itemTouchListener : ((ContactData) -> Unit)

    object ContactDiffUtil : DiffUtil.ItemCallback<ContactData>() {
        override fun areItemsTheSame(oldItem: ContactData, newItem: ContactData): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: ContactData, newItem: ContactData): Boolean {
            return oldItem.firstName == newItem.firstName
        }
    }

    inner class ContactViewHolder(private val binding: ItemSwipeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {




            Log.d("TAG", "bind: ishladi")
            getItem(absoluteAdapterPosition).apply {
                binding.contactFirstName.text = firstName
                binding.contactLastName.text = lastName
                binding.contactNumber.text = phoneNumber
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        ContactViewHolder(ItemSwipeBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {

        Log.d("TAG", "bind: ${currentList.size}")
        holder.bind()
    }
}