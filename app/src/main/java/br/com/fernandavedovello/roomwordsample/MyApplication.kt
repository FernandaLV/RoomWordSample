package br.com.fernandavedovello.roomwordsample

import android.app.Application
import br.com.fernandavedovello.roomwordsample.di.dbModule
import br.com.fernandavedovello.roomwordsample.di.repositoryModel
import br.com.fernandavedovello.roomwordsample.di.uiModule
import br.com.fernandavedovello.roomwordsample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@MyApplication)
            // declare modules
            modules(
                listOf(
                    viewModelModule,
                    uiModule,
                    dbModule,
                    repositoryModel
                )
            )
        }
    }
}