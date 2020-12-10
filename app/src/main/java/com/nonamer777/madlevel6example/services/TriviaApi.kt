package com.nonamer777.madlevel6example.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TriviaApi {

    companion object {

        private const val BASE_URL = "http:/numbersapi.com/"

        fun createApi(): ITriviaApiService {
            val httpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

            val triviaApi = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
            .build()

            return triviaApi.create(ITriviaApiService::class.java)
        }
    }
}
