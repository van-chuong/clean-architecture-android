package com.example.clean_chitecture.presentation.views.building

import android.view.LayoutInflater
import com.example.clean_chitecture.databinding.FragmentSelectBuildingBinding
import com.example.clean_chitecture.presentation.base.BaseFragment
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