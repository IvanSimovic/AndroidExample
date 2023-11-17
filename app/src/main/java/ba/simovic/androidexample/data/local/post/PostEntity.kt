package ba.simovic.androidexample.data.local.post

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class PostEntity(
    @PrimaryKey(autoGenerate = true)  val id: Long,
    val title: String,
    val text: String
)