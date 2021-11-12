package ua.shumov.cleanarchi.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun getOkHttp(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        return builder.build()
    }

    @Singleton
    @Provides
    fun getRetroFit(): Retrofit {
        val builder = Retrofit.Builder()
        builder.baseUrl(getBaseURL())
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        builder.addConverterFactory(GsonConverterFactory.create())
        builder.client(getOkHttp())
        return builder.build()
    }

    @Provides
    @Named("baseUrl")
    fun getBaseURL(): String {
        return "https://jsonplaceholder.typicode.com/"
    }

    @Provides
    @Named("apiKey")
    fun getApiKey(): String {
        return "2519e99a-960e-4869-8bce-27e2ed46c54a"
    }
}