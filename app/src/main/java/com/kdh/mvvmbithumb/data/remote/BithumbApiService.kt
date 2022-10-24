package com.kdh.mvvmbithumb.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface BithumbApiService {
    @GET("public/ticker/ALL_KRW")
//    suspend fun getKRWTickers(): Response<Any>
    fun getKRWCoinInfoList(): Response<Any>

}