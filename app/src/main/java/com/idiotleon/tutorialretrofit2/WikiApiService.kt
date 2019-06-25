package com.idiotleon.tutorialretrofit2

import android.database.Observable
import android.graphics.ColorSpace
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WikiApiService {

    @GET("api.php")
    fun hitCountCheck(
        @Query("action") action: String,
        @Query("format") format: String,
        @Query("list") list: String,
        @Query("srsearch") srsearch: String
    ): Observable<Model.Result>

    companion object {
        val BASE_URL = "https://en.wikipedia.org"
        fun create(): WikiApiService {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(WikiApiService::class.java)
        }
    }
}