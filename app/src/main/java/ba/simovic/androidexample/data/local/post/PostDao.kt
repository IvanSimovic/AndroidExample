package ba.simovic.androidexample.data.local.post

import androidx.room.*

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(postEntity: PostEntity)

    @Query("SELECT * FROM PostEntity")
    suspend fun select(): List<PostEntity>

    @Query("SELECT * FROM PostEntity WHERE id = :id")
    suspend fun select(id: Long): PostEntity

    @Query("DELETE FROM PostEntity WHERE id == :id")
    suspend fun delete(id: String)
}