package com.example.apicall.repo

import com.example.apicall.MyConstans
import com.example.apicall.ui.theme.data.API
import com.example.apicall.ui.theme.data.Entry
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class APIRespository {
    suspend fun callAPI(): List<Entry>? {
        return withContext(Dispatchers.IO) {
            val okHttpClient = OkHttpClient.Builder().build()
            val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            val apiJsonAdapter = moshi.adapter(API::class.java)

            val request = Request
                .Builder()
                .addHeader("Accept","application/json")
                .url(MyConstans.BASE_URL)
                .build()

            val resBody = okHttpClient.newCall(request).execute().use {
                if (!it.isSuccessful) throw IOException("Unexpected code $it")
                val api = apiJsonAdapter.fromJson(it.body!!.source())

                return@use api?.entries
                }
            return@withContext resBody
            }
        }
    }

