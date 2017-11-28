package com.example.kotlin.glossaryapplication

/**
 * Created by ltaoo on 2017/11/28.
 */
object SearchRepositoryProvider {
    fun provideSearchRepository(): SearchRepository {
        return SearchRepository(GithubApiService.Factory.create())
    }
}