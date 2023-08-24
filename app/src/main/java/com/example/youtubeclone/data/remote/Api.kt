package com.example.youtubeclone.data.remote

import com.example.youtubeclone.data.model.Playlist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("playlists")
    fun getPlaylists(
        @Query("part") part: String = "contentDetails, snippet",
        @Query("channelId") channelId: String = "UCRtiU-lpcBSi-ipFKyfIkug",
        @Query("key") key: String = com.example.youtubeclone.BuildConfig.API_KEY,
        @Query("maxResults") maxResults: Int = 10,
    ) : Call<Playlist>
}