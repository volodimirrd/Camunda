package com.jsp.camunda

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CamundaApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        setUpKoin()

    }

    private fun setUpKoin() = startKoin {
        androidContext(this@CamundaApplication)
        modules(listOf(viewModelModule, repositoryModule))
    }
}