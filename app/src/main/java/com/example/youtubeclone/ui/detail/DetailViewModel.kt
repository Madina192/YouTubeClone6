package com.example.youtubeclone.ui.detail

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.youtubeclone.core.base.BaseViewModel
import com.example.youtubeclone.data.model.PlaylistsModel
import com.example.youtubeclone.data.repository.Repository

class DetailViewModel(private val repository: Repository) : BaseViewModel() {

    fun getPlaylistItems(playlistId: String): LiveData<PagingData<PlaylistsModel.Item>> =
        repository.getPlaylistItems(playlistId)
}