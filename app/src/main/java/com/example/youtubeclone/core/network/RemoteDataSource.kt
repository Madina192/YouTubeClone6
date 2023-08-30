package com.example.youtubeclone.core.network

import com.example.youtubeclone.BuildConfig
import com.example.youtubeclone.core.base.BaseDataSource
import com.example.youtubeclone.data.remote.RetrofitService
import com.example.youtubeclone.utils.Constants

class RemoteDataSource : BaseDataSource() {

    private val apiService = RetrofitService.getApiService()

    fun getPlaylists() = getResult {
        apiService.getPlaylists(
            key = BuildConfig.API_KEY,
            part = Constants.PART,
            channelId = Constants.CHANNEL_ID,
            maxResults = 10
        )
    }
}