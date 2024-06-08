package com.gilbersoncampos.pokeguide.di

import com.gilbersoncampos.pokeguide.BuildConfig
import com.gilbersoncampos.pokeguide.data.network.datasource.NetworkDataSource
import com.gilbersoncampos.pokeguide.data.network.datasource.NetworkDataSourceImpl
import com.gilbersoncampos.pokeguide.data.network.retrofit.PokeApiNetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val BASE_URL = BuildConfig.BASE_URL
private const val READ_TIMEOUT_SECONDS = 60L
private const val CONNECT_TIMEOUT_SECONDS = 60L
@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {
    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient =
        OkHttpClient
            .Builder()
            .readTimeout(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .build()

    @Singleton
    @Provides
    fun providesNetworkRetrofit(okHttpClient: OkHttpClient): Retrofit.Builder =
        Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())


    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit.Builder): PokeApiNetworkService =
        retrofit.baseUrl(BASE_URL).build().create(PokeApiNetworkService::class.java)

    @Provides
    fun provideApiHelper(apiHelper: NetworkDataSourceImpl): NetworkDataSource =
        apiHelper
}