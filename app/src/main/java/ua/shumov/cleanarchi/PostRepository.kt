package ua.shumov.cleanarchi

import androidx.lifecycle.LiveData

interface PostRepository {
    fun findById(id: Long): LiveData<Posts>
    fun findAll(): LiveData<List<Posts>>
    fun insert(post: Posts): Long
    fun delete(post: Posts): Long
}