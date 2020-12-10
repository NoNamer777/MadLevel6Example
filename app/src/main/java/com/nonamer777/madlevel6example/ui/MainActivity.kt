package com.nonamer777.madlevel6example.ui

import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.nonamer777.madlevel6example.R
import com.nonamer777.madlevel6example.databinding.ActivityMainBinding
import com.nonamer777.madlevel6example.model.TriviaViewModel

class MainActivity: AppCompatActivity() {

    private val triviaViewModel: TriviaViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setSupportActionBar(findViewById(R.id.toolbar))
        setContentView(binding.root)

        actionBar?.title = getString(R.string.app_name)

        binding.btnGetTriviaNumber.setOnClickListener { triviaViewModel.getTriviaNumber() }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        return true
    }
}
