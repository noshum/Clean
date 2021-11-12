package ua.shumov.cleanarchi.di.modules

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import ua.shumov.cleanarchi.MainApplication
import javax.inject.Singleton

@Module
class ApplicationModule(private var application: MainApplication) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Application = application
}