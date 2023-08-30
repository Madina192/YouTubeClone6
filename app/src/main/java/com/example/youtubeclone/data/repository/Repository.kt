package com.example.youtubeclone.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeclone.core.network.RemoteDataSource
import com.example.youtubeclone.core.network.Resource
import com.example.youtubeclone.data.model.PlaylistModel


class Repository {

    private val remoteDataSource = RemoteDataSource()

    fun getPlaylist(): LiveData<Resource<PlaylistModel>> {
        val data = MutableLiveData<Resource<PlaylistModel>>()
        data.postValue(remoteDataSource.getPlaylists())
        Log.e("ololo", data.value?.data.toString())
        return data
    }
}