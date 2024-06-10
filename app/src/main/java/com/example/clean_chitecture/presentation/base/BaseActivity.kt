package com.example.clean_chitecture.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<viewBinding : ViewBinding, viewModel : BaseViewModel> : AppCompatActivity() {

    protected abstract val viewModel: viewModel
    protected lateinit var viewBinding: viewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = inflateViewBinding(layoutInflater)
        setContentView(viewBinding.root)
        initView()
        initData()
    }

    override fun onStart() {
        super.onStart()
        registerLiveData()
    }

    fun showLoading() {
//        dialogManager.showLoading()
    }

    fun hideLoading() {
//        dialogManager.hideLoading(0)
    }

    abstract fun inflateViewBinding(inflater: LayoutInflater): viewBinding
    abstract fun initView()
    abstract fun initData()

    open fun registerLiveData() {
        viewModel.run {
            isLoading.observe(this@BaseActivity) {
                if (it) showLoading() else hideLoading()
            }
        }
    }

}
