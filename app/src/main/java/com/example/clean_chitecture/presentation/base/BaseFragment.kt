package com.example.clean_chitecture.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<viewBinding : ViewBinding, viewModel : BaseViewModel> : Fragment() {

    protected abstract val viewModel: viewModel

    private var _viewBinding: viewBinding? = null
    protected val viewBinding get() = _viewBinding!!

//    var dialogManager: DialogManager? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _viewBinding = inflateViewBinding(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
        bindView()
        registerLiveData()
        handleEvent()
    }

    fun showLoading() {
//        dialogManager?.showLoading()
    }

    fun hideLoading() {
//        dialogManager?.hideLoading()
    }

    abstract fun inflateViewBinding(inflater: LayoutInflater): viewBinding
    abstract fun setUpView()
    abstract fun bindView()
    abstract fun handleEvent()

    open fun registerLiveData() {
        viewModel.run {
            isLoading.observe(viewLifecycleOwner) {
                if (it) showLoading() else hideLoading()
            }
        }
    }
}
