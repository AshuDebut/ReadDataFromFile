package com.readdatafromfile.app

import android.app.Application
import android.content.Context

class App: Application() {

    companion object AppContext{
        lateinit var instance:App
        fun getContext(): Context {
            return instance.applicationContext
        }
    }
    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
    }
}