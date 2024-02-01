package com.example.contactappbyretrofit.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.contactappbyretrofit.data.remote.response.ContactData
import com.example.contactappbyretrofit.databinding.ItemSwipeBinding

class HomeAdapter(var list : List<ContactData>) : Adapter<HomeAdapter.HomeViewHolder>() {
    inner class HomeViewHolder(binding:ItemSwipeBinding) : ViewHolder(binding.root){
        private val firstName = binding.contactFirstName
        private val lastName = binding.contactLastName
        private val number = binding.contactNumber
        private val root = binding.rootItem


        fun bind() {
            root.setOnClickListener {
                Log.d("TAG", "bind: Assalom")
            }

            firstName.text = list[absoluteAdapterPosition].firstName
            lastName.text = list[absoluteAdapterPosition].lastName
            number.text = list[absoluteAdapterPosition].phoneNumber
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(ItemSwipeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind()
    }
}