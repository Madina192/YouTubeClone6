package com.example.youtubeclone.ui.playlist

import androidx.lifecycle.LiveData
import com.example.youtubeclone.App
import com.example.youtubeclone.core.base.BaseViewModel
import com.example.youtubeclone.core.network.Resource
import com.example.youtubeclone.data.model.PlaylistModel

class PlaylistsViewModel : BaseViewModel() {

    fun getPlayList(): LiveData<Resource<PlaylistModel>> {
        return App().repository.getPlaylist()
    }
}