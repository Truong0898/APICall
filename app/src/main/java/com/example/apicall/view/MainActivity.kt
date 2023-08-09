package com.example.apicall.view

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apicall.R
import com.example.apicall.adapter.ApiAdapter
import com.example.apicall.databinding.ActivityMainBinding
import com.example.apicall.viewmodel.ApiFactory
import com.example.apicall.viewmodel.ApiViewModel
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ApiAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val linearLayoutManager = LinearLayoutManager(this)
        binding.rcvListAPI.layoutManager = linearLayoutManager
        binding.rcvListAPI.setHasFixedSize(true)
        adapter = ApiAdapter(arrayListOf())
        binding.rcvListAPI.adapter = adapter


        val viewModel = ViewModelProvider(this,ApiFactory())[ApiViewModel::class.java]
        viewModel.getListAPI()
        viewModel.lsEntries.observe(this, Observer {
            binding.progressBar.visibility = View.GONE
            binding.rcvListAPI.visibility = View.VISIBLE
            adapter.apply {
                addAPI(it)
                notifyDataSetChanged()
            }
        })

    }
}

