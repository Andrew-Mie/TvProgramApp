package com.nikosis.tvprogramapp.di

import com.nikosis.tvprogramapp.common.Constants
import com.nikosis.tvprogramapp.data.api.TvProgramApi
import com.nikosis.tvprogramapp.data.repository.TvProgramRepo
import com.nikosis.tvprogramapp.data.repository.TvProgramRepoImplement
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTvProgramApi(): TvProgramApi {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TvProgramApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTriviaRepo(api: TvProgramApi): TvProgramRepo {
        return TvProgramRepoImplement(api)
    }
}