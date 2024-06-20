package com.example.clean_chitecture.presentation.di

import com.example.clean_chitecture.presentation.views.building.SelectBuildingViewModel
import com.example.clean_chitecture.presentation.views.login.LoginViewModel
import com.example.clean_chitecture.presentation.views.onboarding.OnboardingViewModel
import com.example.clean_chitecture.presentation.views.otp.OtpViewModel
import com.example.clean_chitecture.presentation.views.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel(get(), get()) }
    viewModel { OnboardingViewModel() }
    viewModel { SelectBuildingViewModel() }
    viewModel { LoginViewModel() }
    viewModel { OtpViewModel() }
}
