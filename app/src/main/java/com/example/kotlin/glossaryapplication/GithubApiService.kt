package com.example.kotlin.glossaryapplication

import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by ltaoo on 2017/11/28.
 */
interface GithubApiService {

    @GET("search/users")
    fun search(@Query("q") query: String,
               @Query("page") page: Int = 1,
               @Query("per_page") perPage: Int = 20): Observable<Result>


    /**
     * Companion object for the factory
     */
    companion object Factory {
        fun create(): GithubApiService {
            val builder = OkHttpClient.Builder()
            if (BuildConfig.DEBUG) {
                // Log信息拦截器
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                //设置 Debug Log 模式
                builder.addInterceptor(loggingInterceptor)
            }
            val okHttpClient = builder.build()
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory.create())
                    .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                    .baseUrl("https://api.github.com/")
                    .client(okHttpClient)
                    .build()

            return retrofit.create(GithubApiService::class.java);
        }
    }
}