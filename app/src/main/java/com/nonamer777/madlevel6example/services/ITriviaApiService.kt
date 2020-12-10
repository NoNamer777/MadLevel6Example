package com.nonamer777.madlevel6example.services

import com.nonamer777.madlevel6example.model.Trivia
import retrofit2.http.GET

interface ITriviaApiService {

    @GET("/random/trivia?json")
    suspend fun getRandomNumberTrivia(): Trivia
}
