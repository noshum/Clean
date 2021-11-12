package ua.shumov.cleanarchi

import androidx.lifecycle.LiveData
import androidx.room.*
import ua.shumov.cleanarchi.Posts.Companion.POST_ID
import ua.shumov.cleanarchi.Posts.Companion.POST_TABLE_NAME

@Dao
interface PostDao {

    @Query("select Count(*) from $POST_TABLE_NAME")
    fun countAll(): Int

    @Query("select * from $POST_TABLE_NAME")
    fun findAll(): LiveData<List<Posts>>

    @Query("select * from $POST_TABLE_NAME where $POST_ID = :id")
    fun findById(id: Long): LiveData<Posts>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(post: Posts): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(post: Posts): Long

    @Delete
    fun delete(post: Posts): Long

    @Query("DELETE FROM $POST_TABLE_NAME")
    fun nukeTable()
}