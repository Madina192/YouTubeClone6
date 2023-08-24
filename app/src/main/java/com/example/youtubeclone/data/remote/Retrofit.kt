package com.example.youtubeclone.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    var retrofit = Retrofit.Builder().baseUrl(com.example.youtubeclone.BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    var api = retrofit.create(Api::class.java)
}