package com.example.clean_chitecture.presentation.views.building

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clean_chitecture.R
import com.example.clean_chitecture.databinding.FragmentOnboardingBinding
import com.example.clean_chitecture.databinding.FragmentSelectBuildingBinding
import com.example.clean_chitecture.presentation.base.BaseFragment
import com.example.clean_chitecture.presentation.views.onboarding.OnboardingFragmentDirections
import com.example.clean_chitecture.presentation.views.onboarding.OnboardingViewModel
import com.example.clean_chitecture.shared.extensions.navigate
import org.koin.androidx.viewmodel.ext.android.viewModel

class SelectBuildingFragment : BaseFragment<FragmentSelectBuildingBinding, OnboardingViewModel>() {

    override val viewModel: OnboardingViewModel by viewModel()

    override fun inflateViewBinding(inflater: LayoutInflater) = FragmentSelectBuildingBinding.inflate(inflater)

    override fun setUpView() {}

    override fun bindView() {}

    override fun handleEvent() {
        viewBinding.button.setOnClickListener {
            navigate(SelectBuildingFragmentDirections.actionToLogin())
        }
    }

}