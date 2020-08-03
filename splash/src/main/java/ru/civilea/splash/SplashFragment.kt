package ru.civilea.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.civilea.core.model.getMainNavController

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val viewModel by viewModel<SplashVewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getMainNavController()?.let {
            viewModel.goToCityFragment(navigator = get(), navController = it)
        }
    }
}
