package com.bina.binarickymorty.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.KoinAppDeclaration

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(appDeclaration = KoinAppDeclarationProvider.get(this))
    }

    object KoinAppDeclarationProvider {

        fun get(application: Application): KoinAppDeclaration = {
            androidContext(application)
            ListCharactersModule().load()
        }
    }
}