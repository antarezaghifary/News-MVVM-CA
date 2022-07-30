package com.needcode.news_mvvm_ca.data.util

sealed class DataState<T> {
    data class Success<T>(val data: T) : DataState<T>()
    data class Error<T>(val error: Throwable) : DataState<T>()
}