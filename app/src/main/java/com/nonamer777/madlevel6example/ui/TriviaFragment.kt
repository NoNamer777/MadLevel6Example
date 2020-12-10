package com.nonamer777.madlevel6example.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.nonamer777.madlevel5task2.utils.viewBinding.IViewBindingHolder
import com.nonamer777.madlevel5task2.utils.viewBinding.ViewBindingHolder
import com.nonamer777.madlevel6example.R
import com.nonamer777.madlevel6example.databinding.FragmentTriviaBinding
import com.nonamer777.madlevel6example.model.TriviaViewModel

/**
 * A [Fragment] subclass that shows the incoming trivia from the api calls.
 */
class TriviaFragment: Fragment(), IViewBindingHolder<FragmentTriviaBinding> by ViewBindingHolder() {

    private val triviaViewModel: TriviaViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = initBinding(
        FragmentTriviaBinding.inflate(layoutInflater),
        this
    ) {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeTrivia()
    }

    private fun observeTrivia() = requireBinding {
        triviaViewModel.trivia.observe(viewLifecycleOwner, {

            tvTrivia.text = it?.text
        })

        triviaViewModel.error.observe(viewLifecycleOwner, {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        })
    }
}
