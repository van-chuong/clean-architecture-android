package com.example.domain.usecase

/*
* Code something for base
* */

abstract class UseCase<in Params, out T> where T : Any {

    abstract suspend fun createObservable(param: Params? = null): T

    abstract fun onCleared()
}