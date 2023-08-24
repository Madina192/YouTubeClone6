package com.example.youtubeclone.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeclone.R
import com.example.youtubeclone.core.base.BaseActivity
import com.example.youtubeclone.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun inflateViewBinding(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override fun initViewModel(): MainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

    private val adapter = PlaylistAdapter()

    override fun initLiveData() {
        super.initLiveData()
        viewModel.playlists.observe(this) {
            adapter.setList(it)
        }
    }

    override fun initView() {
        super.initView()
        binding.recyclerView.adapter = adapter
        viewModel.getPlayList()
    }
}