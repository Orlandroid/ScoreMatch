package com.example.scorematchstatistics.data.state

import java.lang.Exception

sealed class Result<out R> {

    class Success<out T>(val data: T) : Result<T>()
    class Error<out T>(val error: String) : Result<T>()
    class ErrorNetwork<out T>(val error: String) : Result<T>()
    object Loading : Result<Nothing>()

}
