package com.example.youtubeclone.ui.playlist

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeclone.core.base.BaseActivity
import com.example.youtubeclone.core.network.Resource
import com.example.youtubeclone.data.model.PlaylistModel
import com.example.youtubeclone.databinding.ActivityPlaylistsBinding
import com.example.youtubeclone.ui.detail.DetailActivity
import com.example.youtubeclone.utils.ConnectionLiveData

class PlaylistsActivity : BaseActivity<ActivityPlaylistsBinding, PlaylistsViewModel>() {

    override fun inflateViewBinding(): ActivityPlaylistsBinding =
        ActivityPlaylistsBinding.inflate(layoutInflater)

    override fun initViewModel(): PlaylistsViewModel =
        ViewModelProvider(this)[PlaylistsViewModel::class.java]

    private val adapter = PlaylistsAdapter(this::onClick)

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
        ConnectionLiveData(application).observe(this) { isConnection ->
            if (isConnection) {
                binding.mainContainer.visibility = View.VISIBLE
                binding.noConnection.visibility = View.GONE
            }
            binding.noInternetConnectionInclude.btnTryAgain.setOnClickListener {
                if (!isConnection) {
                    binding.mainContainer.visibility = View.GONE
                    binding.noConnection.visibility = View.VISIBLE
                } else {
                    binding.mainContainer.visibility = View.VISIBLE
                    binding.noConnection.visibility = View.GONE
                }
            }
        }
    }

    private fun onClick(item: PlaylistModel.Item) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(ID, item.id)
        intent.putExtra(TITLE, item.snippet.title)
        intent.putExtra(DESCRIPTION, item.snippet.description)
        intent.putExtra(ITEM_COUNT, item.contentDetails.itemCount.toString())
        startActivity(intent)
    }

    override fun initView() {
        super.initView()
        binding.recyclerView.adapter = adapter
    }

    companion object {
        const val ID = "id"
        const val TITLE = "title"
        const val DESCRIPTION = "description"
        const val ITEM_COUNT = "item_count"
    }
}