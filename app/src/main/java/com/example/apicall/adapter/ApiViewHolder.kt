package com.example.apicall.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.apicall.databinding.ItemViewBinding
import com.example.apicall.ui.theme.data.API
import com.example.apicall.ui.theme.data.Entry

class ApiViewHolder(private val binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(entry: Entry) {
        binding.txtAPIName.text = entry.apiName
        binding.txtAuth.text = entry.auth
        binding.txtDescription.text = entry.description
        binding.txtCors.text = entry.cors
        binding.txtHttps.text = entry.https.toString()
        binding.txtCategory.text = entry.category
        binding.txtLink.text = entry.link
    }
}