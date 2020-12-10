package com.nonamer777.madlevel6example.model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nonamer777.madlevel6example.repository.TriviaRepository
import com.nonamer777.madlevel6example.repository.exception.TriviaRefreshError
import kotlinx.coroutines.launch

class TriviaViewModel(application: Application): AndroidViewModel(application) {

    private val triviaRepo = TriviaRepository()

    private val _error: MutableLiveData<String> = MutableLiveData()

    val trivia = triviaRepo.trivia

    val error: LiveData<String> get() = _error

    fun getTriviaNumber() = viewModelScope.launch {
        try { triviaRepo.getRandomNumberTrivia() } catch (error: TriviaRefreshError) {
            _error.value = error.message

            Log.e("Trivia exception", error.cause.toString())
        }
    }
}
