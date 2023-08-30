package com.example.youtubeclone.data.remote

import com.example.youtubeclone.data.model.PlaylistModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApiService {
    @GET("playlists")
    fun getPlaylists(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") key: String,
        @Query("maxResults") maxResults: Int,
    ): Response<PlaylistModel>
}