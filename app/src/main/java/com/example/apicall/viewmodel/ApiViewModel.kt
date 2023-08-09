package com.example.apicall.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicall.repo.APIRespository
import com.example.apicall.ui.theme.data.Entry
import kotlinx.coroutines.launch

class ApiViewModel(private val apiRespository: APIRespository): ViewModel() {
    private val _lsEntries = MutableLiveData<List<Entry>>()

    val lsEntries: LiveData<List<Entry>>
        get() = _lsEntries

    fun getListAPI() {
        viewModelScope.launch {
            _lsEntries.postValue(apiRespository.callAPI())
        }
    }
}