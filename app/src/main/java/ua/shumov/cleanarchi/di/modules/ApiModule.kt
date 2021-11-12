package ua.shumov.cleanarchi.di.modules

import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import retrofit2.Retrofit
import ua.shumov.cleanarchi.Posts
import ua.shumov.cleanarchi.PostsAPI
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun getPostsApi(retrofit: Retrofit): Observable<List<Posts>> {
        val postsApi = retrofit.create(PostsAPI::class.java)
        return postsApi.getPosts()
    }
}