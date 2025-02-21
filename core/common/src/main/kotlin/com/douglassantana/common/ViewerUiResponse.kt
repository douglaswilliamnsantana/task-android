package com.douglassantana.common

sealed class ViewerUiResponse<out T> {
    data class Success<out R>(val value: R) : ViewerUiResponse<R>()
    data class Loading(val isLoad: Boolean = false) : ViewerUiResponse<Nothing>()
    data class Error(val cause: Throwable) : ViewerUiResponse<Nothing>()
}