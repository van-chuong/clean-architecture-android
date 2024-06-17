package com.example.clean_chitecture.presentation.views.otp

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clean_chitecture.R
import com.example.clean_chitecture.databinding.FragmentLoginBinding
import com.example.clean_chitecture.databinding.FragmentOtpBinding
import com.example.clean_chitecture.presentation.base.BaseFragment
import com.example.clean_chitecture.presentation.views.login.LoginFragmentDirections
import com.example.clean_chitecture.presentation.views.onboarding.OnboardingViewModel
import com.example.clean_chitecture.shared.extensions.navigate
import org.koin.androidx.viewmodel.ext.android.viewModel

class OtpFragment : BaseFragment<FragmentOtpBinding, OnboardingViewModel>() {

    override val viewModel: OnboardingViewModel by viewModel()

    override fun inflateViewBinding(inflater: LayoutInflater) = FragmentOtpBinding.inflate(inflater)

    override fun setUpView() {}

    override fun bindView() {}

    override fun handleEvent() {
        viewBinding.button.setOnClickListener {
            navigate(OtpFragmentDirections.actionToSensor())
        }
    }

}