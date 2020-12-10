package com.nonamer777.madlevel6example.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nonamer777.madlevel6example.model.Trivia
import com.nonamer777.madlevel6example.repository.exception.TriviaRefreshError
import com.nonamer777.madlevel6example.services.ITriviaApiService
import com.nonamer777.madlevel6example.services.TriviaApi
import kotlinx.coroutines.withTimeout

class TriviaRepository {

    private val triviaApiService: ITriviaApiService = TriviaApi.createApi()

    private val _trivia: MutableLiveData<Trivia> = MutableLiveData()

    val trivia: LiveData<Trivia> get() = _trivia

    suspend fun getRandomNumberTrivia() {
        try {
            val result = withTimeout(5_000) { triviaApiService.getRandomNumberTrivia() }

            _trivia.value = result
        } catch (error: Throwable) {
            throw TriviaRefreshError("Unable to refresh trivia", error)
        }
    }
}
