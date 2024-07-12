package com.my.postapitask.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.my.postapitask.MainVM
import com.my.postapitask.R

class Login: Fragment(R.layout.activity_main) {
    private val viewModel : MainVM by viewModels()
}