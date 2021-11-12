package ua.shumov.cleanarchi

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

class PostsViewModel @Inject constructor(application: Application,
    private val postsObservable: Observable<List<Posts>>) : AndroidViewModel(application) {

    private var posts = MutableLiveData<List<Posts>>()

    private fun watchPosts() {
        postsObservable
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread()).subscribe { listOfPosts ->
                if (listOfPosts != null) setPosts(listOfPosts)
            }
    }

    private fun setPosts(posts: List<Posts>) {
        this.posts.postValue(posts)
    }

    fun getPosts(): LiveData<List<Posts>> {
        return this.posts
    }

    init {
        watchPosts()
    }
}