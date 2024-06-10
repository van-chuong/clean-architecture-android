package com.example.clean_chitecture.presentation.views.splash

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clean_chitecture.R
import com.example.clean_chitecture.databinding.FragmentHomeBinding
import com.example.clean_chitecture.databinding.FragmentSplashBinding
import com.example.clean_chitecture.presentation.views.home.HomeViewModel
import com.example.clean_chitecture.shared.extensions.navigate
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SplashViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.isLoading.observe(viewLifecycleOwner){
            if(!it){
                navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
            }
        }

    }
}