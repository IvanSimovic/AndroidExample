package ba.simovic.androidexample.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import ba.simovic.androidexample.data.local.post.PostDao
import ba.simovic.androidexample.data.local.post.PostEntity
import java.util.*
import javax.inject.Singleton

@Singleton
@TypeConverters(value = [Convertor::class])
@Database(
    entities = [PostEntity::class],
    version = 4
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}

object Convertor {

    @TypeConverter
    @JvmStatic
    fun toDate(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    @JvmStatic
    fun toLong(value: Date?): Long? {
        return value?.time
    }

    @TypeConverter
    @JvmStatic
    fun toInt(value: Boolean) = if (value) 1 else 0

    @TypeConverter
    @JvmStatic
    fun toBoolean(value: Int) = value == 1
}

@Suppress("NOTHING_TO_INLINE")
private inline fun <T : Enum<T>> T.toInt(): Int = this.ordinal

private inline fun <reified T : Enum<T>> Int.toEnum(): T = enumValues<T>()[this]

// Migration example
val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE `PostEntity` ADD `newExampleField` INTEGER NOT NULL DEFAULT 1")
        database.execSQL("DROP TABLE `PostEntity`")
        database.execSQL("CREATE TABLE `PostEntity` (id TEXT not NULL, Text TEXT not NULL, Title TEXT not NULL, PRIMARY KEY(id))")
    }
}
