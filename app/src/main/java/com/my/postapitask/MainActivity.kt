package com.my.postapitask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.activity.viewModels
import com.my.postapitask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var btSubmit : Button

    private val viewModel: MainVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btSubmit = findViewById(R.id.btSubmit)

        btSubmit.setOnClickListener {
            viewModel.userName = binding.etName.text.toString()
            viewModel.password = binding.etPassword.text.toString()
            viewModel.login()
        }

    }


}