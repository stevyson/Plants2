package com.stevyson.plants.myplantsapp.di

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.stevyson.plants.myplantsapp.common.Constants
import com.stevyson.plants.myplantsapp.data.remote.PerenualApi
import com.stevyson.plants.myplantsapp.data.repository.PlantRepositoryImpl
import com.stevyson.plants.myplantsapp.domain.repository.PlantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoshi(): MoshiConverterFactory {
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

        return MoshiConverterFactory.create(moshi)
    }

    @Provides
    @Singleton
    fun providePerenualApi(
        moshi: MoshiConverterFactory
    ): PerenualApi {
        val client = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor { message ->
            Log.e("RETROFIT", message)
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        client.addInterceptor(interceptor)

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(moshi)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()
            .create(PerenualApi::class.java)
    }

    @Provides
    @Singleton
    fun providePlantRepository(api: PerenualApi): PlantRepository {
        return PlantRepositoryImpl(api)
    }
}