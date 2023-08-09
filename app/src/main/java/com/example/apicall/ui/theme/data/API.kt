package com.example.apicall.ui.theme.data

import com.squareup.moshi.Json

data class API(
    @Json(name = "entries") val entries: List<Entry>,
    @Json(name = "count") val count: Int
)

data class Entry(
    @Json(name = "API") val apiName: String,
    @Json(name = "Description") val description: String,
    @Json(name = "Auth") val auth: String,
    @Json(name = "HTTPS") val https: Boolean,
    @Json(name = "Cors") val cors: String,
    @Json(name = "Link") val link: String,
    @Json(name = "Category") val category: String
)