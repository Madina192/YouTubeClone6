package com.example.youtubeclone

import android.app.Application
import com.example.youtubeclone.data.repository.Repository

class App : Application() {

    val repository: Repository by lazy {
        Repository()
    }
}