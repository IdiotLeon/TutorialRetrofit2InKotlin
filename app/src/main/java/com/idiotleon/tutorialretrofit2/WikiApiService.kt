package com.idiotleon.tutorialretrofit2

import android.database.Observable
import android.graphics.ColorSpace
import retrofit2.http.GET
import retrofit2.http.Query

interface WikiApiService {

    @GET("api.php")
    fun hitCountCheck(@Query("action") action:String,
                      @Query("format") format:String,
                      @Query("list") list:String,
                      @Query("srsearch")srsearch:String):Observable<Model.Result>

}