package ba.simovic.androidexample.data.di

import ba.simovic.androidexample.data.local.post.PostDao
import ba.simovic.androidexample.data.repository.PostRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {

    @Provides
    @Singleton
    fun providePostRepo(postDao: PostDao) = PostRepo(postDao)

}