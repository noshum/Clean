package ua.shumov.cleanarchi

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ua.shumov.cleanarchi.AppDatabase.Companion.VERSION

@Database(entities = arrayOf(Posts::class), version = VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val postDao: PostDao

    companion object {
        internal const val VERSION = 1

        private const val DATABASE_NAME: String = "testDB"
        private var dbInstance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase? {
            if (dbInstance == null) {
                dbInstance = Room.databaseBuilder<AppDatabase>(context, AppDatabase::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries().build()
            }
            return dbInstance
        }
    }
}