package com.kalum.wheel

import dagger.android.AndroidInjector

class TestApp : App() {

    override fun applicationInjector(): AndroidInjector<out TestApp> {
        return DaggerTestAppComponent.builder().create(this)
    }

}