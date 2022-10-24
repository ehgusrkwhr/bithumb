package com.kdh.mvvmbithumb.data.remote.repository

import retrofit2.Response
import javax.inject.Inject

class CoinInfoRepositoryImpl @Inject constructor() : CoinInfoRepository {

    override suspend fun getKRWCoinInfoList(): Response<Any> {
        TODO("Not yet implemented")
    }

}