package com.example.youtubeclone.ui.playlist

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.youtubeclone.core.base.BaseViewModel
import com.example.youtubeclone.data.model.PlaylistsModel
import com.example.youtubeclone.data.repository.Repository

class PlaylistsViewModel(private val repository: Repository) : BaseViewModel() {

    fun getPlayList(): LiveData<PagingData<PlaylistsModel.Item>> {
        return repository.getPlaylist()
    }
}