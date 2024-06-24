package com.example.clean_chitecture.shared.extensions

fun String?.isNotEmptyBlank() = !this.isNullOrEmpty() && this.isNotBlank()
