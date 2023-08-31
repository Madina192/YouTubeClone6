package com.example.youtubeclone.ui.detail

import androidx.lifecycle.LiveData
import com.example.youtubeclone.App
import com.example.youtubeclone.core.base.BaseViewModel
import com.example.youtubeclone.core.network.Resource
import com.example.youtubeclone.data.model.PlaylistItemModel

class DetailViewModel : BaseViewModel() {

    fun getPlaylistItems(playlistId: String): LiveData<Resource<PlaylistItemModel>> {
        return App().repository.getPlaylistItems(playlistId)
    }
}