package com.example.clean_chitecture.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.shared.scheduler.DataResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val isSuccess = MutableLiveData<Boolean>()
    val exception = MutableLiveData<Exception>()

    init {
        isLoading.postValue(true)
    }

    protected fun <T> launchTaskSync(
        onRequest: suspend CoroutineScope.() -> DataResult<T>,
        onSuccess: (T) -> Unit = {},
        onError: (Exception) -> Unit = {}
    ) = viewModelScope.launch {
        isLoading.postValue(true)
        when (val result = onRequest()) {
            is DataResult.Success -> {
                isSuccess.postValue(true)
                onSuccess(result.data)
            }

            is DataResult.Error -> {
                isSuccess.postValue(false)
                onError(result.exception)
            }

            is DataResult.Loading -> {}
        }
        isLoading.postValue(false)
    }

}
