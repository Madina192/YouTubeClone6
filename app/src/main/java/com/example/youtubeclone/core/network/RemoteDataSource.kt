package com.example.youtubeclone.core.network

import com.example.youtubeclone.BuildConfig
import com.example.youtubeclone.core.base.BaseDataSource
import com.example.youtubeclone.data.model.PlaylistItemModel
import com.example.youtubeclone.utils.Constants

class RemoteDataSource : BaseDataSource() {

    private val apiService = RetrofitService.getApiService()

    suspend fun getPlaylists() = getResult {
        apiService.getPlaylists(
            key = BuildConfig.API_KEY,
            part = Constants.PART,
            channelId = Constants.CHANNEL_ID,
            maxResults = 10
        )
    }

    suspend fun getPlaylistItems(playlistId: String): Resource<PlaylistItemModel> {
        return getResult {
            apiService.getPlaylistItems(
                key = BuildConfig.API_KEY,
                part = Constants.PART,
                playlistId = playlistId,
                maxResults = 20
            )
        }
    }
}