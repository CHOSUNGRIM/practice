package com.example.apophischatingtest.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.apophischatingtest.databinding.ActivityMainBinding
import com.example.apophischatingtest.presentation.adapter.MainAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            lifecycleOwner = this@MainActivity
            vm = viewModel
        }
        initView()
        subscribeData()
    }

    private fun initView() {
        mainAdapter = MainAdapter()
        binding.mainRcv.adapter = mainAdapter
    }

    private fun subscribeData() {
        viewModel.number.observe(this) { data ->
            mainAdapter.submitList(data)
        }
    }
}