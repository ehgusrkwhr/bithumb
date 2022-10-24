package com.kdh.mvvmbithumb.data.remote.repository

import retrofit2.Response

interface CoinInfoRepository {

    suspend fun getKRWCoinInfoList(): Response<Any>

}