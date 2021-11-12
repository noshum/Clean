package ua.shumov.cleanarchi

import androidx.lifecycle.LiveData
import javax.inject.Inject

class PostDataSource @Inject
constructor(private val postDao: PostDao) : PostRepository {

    override fun findById(id: Long): LiveData<Posts> {
        return postDao.findById(id)
    }

    override fun findAll(): LiveData<List<Posts>> {
        return postDao.findAll()
    }

    override fun insert(post: Posts): Long {
        return postDao.insert(post)
    }

    override fun delete(post: Posts): Long {
        return postDao.delete(post)
    }
}