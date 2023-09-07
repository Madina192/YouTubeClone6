package com.example.youtubeclone.ui.play

import android.annotation.SuppressLint
import android.view.View
import com.example.youtubeclone.core.base.BaseActivity
import com.example.youtubeclone.databinding.ActivityPlayBinding
import com.example.youtubeclone.utils.ConnectionLiveData
import com.example.youtubeclone.utils.Constants.VIDEO_DESCRIPTION
import com.example.youtubeclone.utils.Constants.VIDEO_ITEM_ID
import com.example.youtubeclone.utils.Constants.VIDEO_TITLE
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayActivity() : BaseActivity<ActivityPlayBinding, PlayViewModel>() {

    override fun inflateViewBinding(): ActivityPlayBinding =
        ActivityPlayBinding.inflate(layoutInflater)

    override val viewModel: PlayViewModel by viewModel()

    @SuppressLint("SetTextI18n")
    override fun initLiveData() {
        super.initLiveData()
        val getIntentItemId = intent.getStringExtra(VIDEO_ITEM_ID)
        val getIntentVideoId = intent.getStringExtra(VIDEO_ITEM_ID)
        val getIntentDesc = intent.getStringExtra(VIDEO_DESCRIPTION)
        val getIntentTitle = intent.getStringExtra(VIDEO_TITLE)
    }

    override fun initView() {
        super.initView()
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        with(binding) {
            tvTitle.text
        }
    }

    override fun initListener() {
        super.initListener()
        binding.llBack.setOnClickListener {
            finish()
        }
    }

    override fun checkInternetConnection() {
        super.checkInternetConnection()
        ConnectionLiveData(application).observe(this) { isConnection ->
            if (!isConnection) {
                binding.mainContainer.visibility = View.GONE
                binding.noConnection.visibility = View.VISIBLE
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
}