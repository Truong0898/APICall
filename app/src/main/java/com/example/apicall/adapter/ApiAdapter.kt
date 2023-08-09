package com.example.apicall.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apicall.databinding.ActivityMainBinding
import com.example.apicall.databinding.ItemViewBinding
import com.example.apicall.ui.theme.data.API
import com.example.apicall.ui.theme.data.Entry

class ApiAdapter(private val lsEntry: ArrayList<Entry>): RecyclerView.Adapter<ApiViewHolder>() {
    private lateinit var binding: ItemViewBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiViewHolder {
        binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ApiViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return lsEntry.size
    }

    override fun onBindViewHolder(holder: ApiViewHolder, position: Int) {
        holder.bind(lsEntry[position])
    }

    fun addAPI(lsAPI: List<Entry>) {
        this.lsEntry.apply {
            clear()
            addAll(lsAPI)
        }
    }
}