package ua.shumov.cleanarchi

import retrofit2.http.GET
import java.util.*

interface PostsAPI {

    @GET("posts/")
    fun getPosts(): Observable<List<Posts>>
}