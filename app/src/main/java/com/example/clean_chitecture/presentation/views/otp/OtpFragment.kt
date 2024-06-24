package com.example.clean_chitecture.presentation.views.otp

import android.view.LayoutInflater
import com.example.clean_chitecture.databinding.FragmentOtpBinding
import com.example.clean_chitecture.presentation.base.BaseFragment
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