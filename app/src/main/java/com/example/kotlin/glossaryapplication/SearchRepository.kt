package com.example.kotlin.glossaryapplication

import io.reactivex.Observable

/**
 * Created by ltaoo on 2017/11/28.
 */
class SearchRepository(val apiService: GithubApiService) {
    fun searchUsers(location: String, language: String): Observable<Result> {
        return apiService.search(query = "location:$location language:$language")
    }
}