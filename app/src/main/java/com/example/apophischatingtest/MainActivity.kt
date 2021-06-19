package com.example.apophischatingtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apophischatingtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    var first = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        val mainAdapter = MainAdapter()
        binding.mainRcv.layoutManager = LinearLayoutManager(this)
        binding.mainRcv.adapter = mainAdapter
        viewModel.number.observe(this) { data ->
            if (first) {
                mainAdapter.initData(data)
                first = false
            }
            else {
                mainAdapter.addChat(data)
            }
        }
    }
}