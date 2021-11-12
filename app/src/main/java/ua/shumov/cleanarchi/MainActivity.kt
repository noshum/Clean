package ua.shumov.cleanarchi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import ua.shumov.cleanarchi.di.modules.ApplicationComponent
import ua.shumov.cleanarchi.di.modules.ApplicationModule
import ua.shumov.cleanarchi.di.modules.RoomModule
import ua.shumov.cleanarchi.utils.logDebug
import ua.shumov.cleanarchi.utils.observe
import ua.shumov.cleanarchi.utils.withViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mComponent = DagerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this.application as MainApplication))
            .roomModule(RoomModule(this.application))
            .build()

        mComponent?.inject(this)

        withViewModel<PostsViewModel>(viewModelFactory) {
            observe(getPosts(), ::updatePosts)
        }
    }

    private fun updatePosts(posts: List<Posts>?) {
        posts?.forEach { post ->
            logDebug(LOG_TAG, post.title)
        }
    }

    companion object {

        @JvmStatic
        var mComponent: ApplicationComponent? = null
        val LOG_TAG: String = MainActivity::class.java.simpleName
    }
}