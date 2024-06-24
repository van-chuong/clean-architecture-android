package com.example.clean_chitecture.presentation.views.login

import android.view.LayoutInflater
import com.example.clean_chitecture.databinding.FragmentLoginBinding
import com.example.clean_chitecture.presentation.base.BaseFragment
import com.example.clean_chitecture.presentation.views.onboarding.OnboardingViewModel
import com.example.clean_chitecture.shared.extensions.navigate
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<FragmentLoginBinding, OnboardingViewModel>() {

    override val viewModel: OnboardingViewModel by viewModel()

    override fun inflateViewBinding(inflater: LayoutInflater) = FragmentLoginBinding.inflate(inflater)

    override fun setUpView() {}

    override fun bindView() {}

    override fun handleEvent() {
        viewBinding.button.setOnClickListener {
            navigate(LoginFragmentDirections.actionLoginToOtp())
        }
    }

}