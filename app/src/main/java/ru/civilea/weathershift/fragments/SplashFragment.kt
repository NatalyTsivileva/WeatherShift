package ru.civilea.weathershift.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.civilea.weathershift.R
import ru.civilea.weathershift.viewModels.CityViewModel
import ru.civilea.weathershift.viewModels.SplashVewModel

class SplashFragment : Fragment() {

    private val viewModel by viewModels<SplashVewModel>()

   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.goToCityFragment(findNavController())
    }

}