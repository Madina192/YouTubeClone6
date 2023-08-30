package com.example.youtubeclone.ui.main

import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeclone.core.base.BaseActivity
import com.example.youtubeclone.core.network.Resource
import com.example.youtubeclone.databinding.ActivityPlaylistsBinding

class PlaylistsActivity : BaseActivity<ActivityPlaylistsBinding, PlaylistsViewModel>() {

    override fun inflateViewBinding(): ActivityPlaylistsBinding =
        ActivityPlaylistsBinding.inflate(layoutInflater)

    override fun initViewModel(): PlaylistsViewModel =
        ViewModelProvider(this)[PlaylistsViewModel::class.java]

    private val adapter = PlaylistsAdapter()

    override fun initLiveData() {
        super.initLiveData()
        viewModel.getPlayList().observe(this) { response ->
            when (response.status) {
                Resource.Status.SUCCESS -> {
                    Toast.makeText(this, "success status", Toast.LENGTH_SHORT).show()
                    adapter.setList(response.data?.items)
                    viewModel.loading.value = false
                }

                Resource.Status.ERROR -> {
                    Toast.makeText(this, "error status", Toast.LENGTH_SHORT).show()
                    viewModel.loading.value = false

                }

                Resource.Status.LOADING -> {
                    Toast.makeText(this, "loading status", Toast.LENGTH_SHORT).show()
                    viewModel.loading.value = true
                }
            }
        }
        viewModel.loading.observe(this) { status ->
            if (status) binding.progressBar.visibility = View.VISIBLE
            else binding.progressBar.visibility = View.GONE
        }
    }

    override fun checkInternetConnection() {
        super.checkInternetConnection()
        //logic...
    }

    override fun initView() {
        super.initView()
        binding.recyclerView.adapter = adapter
        viewModel.getPlayList()
    }
}