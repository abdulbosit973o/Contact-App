package com.example.contactappbyretrofit.presentation.intro

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.contactappbyretrofit.R
import com.example.contactappbyretrofit.databinding.FragmentHomeBinding

class IntroScreen :Fragment(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}