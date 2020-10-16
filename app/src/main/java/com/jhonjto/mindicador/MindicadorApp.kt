package com.jhonjto.mindicador

import android.app.Application

/**
 * Created by jhon on 15/10/2020
 */
class MindicadorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }
}