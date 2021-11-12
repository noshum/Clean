package ua.shumov.cleanarchi.di.modules

import dagger.Component
import ua.shumov.cleanarchi.*
import javax.inject.Singleton


@Component(modules = [(NetworkModule::class), (ApiModule::class), (ViewModelModule::class), (ApplicationModule::class), (RoomModule::class)])
@Singleton
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)

    fun postDao(): PostDao
    fun roomDB(): AppDatabase
    fun postRepository(): PostRepository
}