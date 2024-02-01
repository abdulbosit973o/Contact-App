package com.example.contactappbyretrofit.presentation.home

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.contactappbyretrofit.R
import com.example.contactappbyretrofit.data.remote.request.ContactAddData
import com.example.contactappbyretrofit.data.remote.response.ContactData
import com.example.contactappbyretrofit.databinding.FragmentHomeBinding
import com.example.contactappbyretrofit.presentation.adapter.ContactAdapter
import com.example.contactappbyretrofit.presentation.adapter.HomeAdapter

class HomeScreen :Fragment(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)
//    private val adapter by lazy { ContactAdapter() }
    private var adapter:HomeAdapter? = null
    private val viewModel = HomeViewModel()
    private lateinit var dialog: Dialog
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog = Dialog(requireContext())

        viewModel.loadData()
        viewModel.mutableList.observe(viewLifecycleOwner){
            Log.d("TAG", "onViewCreated: ${it.size}")
            adapter = HomeAdapter(it)
            binding.recyclerView.adapter =adapter
        }
        viewModel.error.observe(viewLifecycleOwner) {
            if (it) binding.progress.show()
            else binding.progress.hide()
        }
        binding.addButton.setOnClickListener{
            openAddDialog()
        }


        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())



//        adapter.itemTouchListener = {
//            showBottomSheetDialog(it)
//        }
    }

    private fun showBottomSheetDialog(it: ContactData) {
        dialog.setContentView(com.google.android.material.R.layout.design_bottom_sheet_dialog)



        dialog.show()

        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.window?.setGravity(Gravity.CENTER)
    }

    @SuppressLint("SuspiciousIndentation")
    private fun openAddDialog() {
        dialog.setContentView(R.layout.dialog_exam)


        dialog.findViewById<AppCompatButton>(R.id.saveBtn).setOnClickListener {
            Log.d("TAG", "openAddDialog: Bosildi")
            val contact = ContactAddData(0,
                dialog.findViewById<AppCompatEditText>(R.id.firstName).text.toString(),
                dialog.findViewById<AppCompatEditText>(R.id.lastName).text.toString(),
                dialog.findViewById<AppCompatEditText>(R.id.phoneNumber).text.toString())
                viewModel.addData(contact)
                dialog.dismiss()
        }


        dialog.show()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.window?.setGravity(Gravity.CENTER)
    }
}