package com.example.youtubeclone.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeclone.core.base.BaseViewModel
import com.example.youtubeclone.data.model.Playlist
import com.example.youtubeclone.data.remote.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : BaseViewModel() {

    private var _playlists: MutableLiveData<Playlist> = MutableLiveData<Playlist>()
    val playlists: LiveData<Playlist> = _playlists

    fun getPlayList() {
        Retrofit.api.getPlaylists().enqueue(
            object : Callback<Playlist> {
                override fun onResponse(
                    call: Call<Playlist>,
                    response: Response<Playlist>
                ) {
                    if (response.isSuccessful) {
                        _playlists.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<Playlist>, t: Throwable) {
                    Log.e("ololo", t.message.toString())
                }

            }
        )
    }
}