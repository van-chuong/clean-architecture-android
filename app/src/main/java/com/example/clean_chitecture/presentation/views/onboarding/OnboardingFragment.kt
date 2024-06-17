package com.example.clean_chitecture.presentation.views.onboarding

import android.view.LayoutInflater
import android.widget.Toast
import com.example.clean_chitecture.databinding.FragmentOnboardingBinding
import com.example.clean_chitecture.presentation.base.BaseFragment
import com.example.clean_chitecture.shared.extensions.navigate
import org.koin.androidx.viewmodel.ext.android.viewModel


class OnboardingFragment : BaseFragment<FragmentOnboardingBinding, OnboardingViewModel>() {

    override val viewModel: OnboardingViewModel by viewModel()

    override fun inflateViewBinding(inflater: LayoutInflater) = FragmentOnboardingBinding.inflate(inflater)

    override fun setUpView() {}

    override fun bindView() {}

    override fun handleEvent() {
        viewBinding.button.setOnClickListener {
            navigate(OnboardingFragmentDirections.actionOnboardingToSelectBuilding())
        }
    }

}