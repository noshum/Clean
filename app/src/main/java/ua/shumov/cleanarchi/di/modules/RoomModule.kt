package ua.shumov.cleanarchi.di.modules

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ua.shumov.cleanarchi.AppDatabase
import ua.shumov.cleanarchi.PostDao
import ua.shumov.cleanarchi.PostDataSource
import ua.shumov.cleanarchi.PostRepository
import javax.inject.Singleton

@Module
class RoomModule(private var application: Application) {

    private var appDatabase: AppDatabase? = null

    init {
        appDatabase = Room.databaseBuilder(application, AppDatabase::class.java, "demoDb").build()
    }

    @Singleton
    @Provides
    fun providesRoomDatabase(): AppDatabase {
        return appDatabase!!
    }

    @Singleton
    @Provides
    fun providesPostDao(demoDatabase: AppDatabase): PostDao {
        return demoDatabase.postDao
    }

    @Singleton
    @Provides
    fun postRepository(postDao: PostDao): PostRepository {
        return PostDataSource(postDao)
    }
}