package com.example.youtubeclone.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.youtubeclone.core.network.RemoteDataSource
import com.example.youtubeclone.data.model.PlaylistsModel
import com.example.youtubeclone.data.paging.DetailsPagingSource
import com.example.youtubeclone.data.paging.PlaylistsPagingSource

class Repository(private val remoteDataSource: RemoteDataSource) {

    fun getPlaylist(): LiveData<PagingData<PlaylistsModel.Item>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = { PlaylistsPagingSource(remoteDataSource = remoteDataSource) }
        ).liveData
    }

    fun getPlaylistItems(playlistId: String): LiveData<PagingData<PlaylistsModel.Item>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                DetailsPagingSource(
                    remoteDataSource = remoteDataSource,
                    playlistId = playlistId
                )
            }
        ).liveData
    }
}