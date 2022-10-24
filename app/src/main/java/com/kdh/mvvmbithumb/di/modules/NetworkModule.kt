package com.kdh.mvvmbithumb.di.modules

import com.kdh.mvvmbithumb.data.remote.BithumbApiService
import com.kdh.mvvmbithumb.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesOkHttpClient() : OkHttpClient{
        return OkHttpClient().newBuilder()
            .addInterceptor{ chain ->
                val request = chain.request()
                val newRequest = request.newBuilder().header("Authorization","Test")
                chain.proceed(newRequest.build())
            }
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    fun providesRetrofit(okHttpClient: OkHttpClient) : Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.Api.BASE_URI)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    fun providesBithumbApiService(retrofit : Retrofit) : BithumbApiService {
        return retrofit.create(BithumbApiService::class.java)

    }
}