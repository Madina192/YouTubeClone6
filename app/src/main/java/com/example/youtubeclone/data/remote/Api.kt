package com.example.youtubeclone.data.remote

import com.example.youtubeclone.data.model.Playlist
import org.koin.android.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("playlists")
    fun getPlaylists(
        @Query("part") part: String = "contentDetails, snippet",
        @Query("channelId") channelId: String = "UCFiaumQAjtZwWlxdbgYP7vw",
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("maxResults") maxResults: Int = 10,
    ) : Call<Playlist>
}