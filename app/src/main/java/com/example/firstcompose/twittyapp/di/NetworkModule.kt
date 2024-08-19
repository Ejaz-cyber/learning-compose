package com.example.firstcompose.twittyapp.di

import com.example.firstcompose.twittyapp.api.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

//    val url = "https://jsonplaceholder.typicode.com"
    val url = "https://crudcrud.com/api/5b350476580c4fb98e1aaeb82c77e2df/"


    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesTwittyApis(retrofit: Retrofit): ApiInterface{
        return retrofit.create(ApiInterface::class.java)
    }
}