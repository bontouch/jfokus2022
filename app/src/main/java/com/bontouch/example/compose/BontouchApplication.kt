package com.bontouch.example.compose

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class BontouchApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this);
    }
}