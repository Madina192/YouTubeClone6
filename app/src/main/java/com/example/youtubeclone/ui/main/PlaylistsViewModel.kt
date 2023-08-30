package com.example.youtubeclone.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeclone.core.base.BaseViewModel
import com.example.youtubeclone.core.network.Resource
import com.example.youtubeclone.data.model.PlaylistModel
import com.example.youtubeclone.data.repository.Repository

class PlaylistsViewModel : BaseViewModel() {

    private val repository = Repository()

    fun getPlayList() : LiveData<Resource<PlaylistModel>>{
        return repository.getPlaylist()
    }
}