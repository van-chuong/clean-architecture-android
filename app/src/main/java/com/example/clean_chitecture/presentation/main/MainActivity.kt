package com.example.clean_chitecture.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.clean_chitecture.R
import com.example.clean_chitecture.databinding.ActivityMainBinding
import com.example.clean_chitecture.presentation.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding = ActivityMainBinding.inflate(inflater)

    override fun initView() {
        viewBinding.viewModel = viewModel
        viewBinding.lifecycleOwner = this@MainActivity

    }

    override fun initData() {
        viewModel.loadMovies(1)
    }

    override fun registerLiveData() {
        super.registerLiveData()
        with(viewModel){
            movies.observe(this@MainActivity) {
                Log.d("Dataaaaa", it.toString())
            }
        }
    }

}