package com.example.chapter6_topic5.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter6_topic5.databinding.ActivityMainBinding
import com.example.chapter6_topic5.viewmodel.ViewModelMakeup
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var makeupAdapter : AdapterMakeup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setVmToAdapter()
    }

        fun setVmToAdapter(){
        val viewModel = ViewModelProvider(this).get(ViewModelMakeup::class.java)
        viewModel.callApiMakeup()
        viewModel.getLiveDataMakup().observe(this, Observer {
            makeupAdapter = AdapterMakeup(it)
            if ( it != null){
                binding.recycleView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.recycleView.adapter = AdapterMakeup(it)

            }

        })
    }
}