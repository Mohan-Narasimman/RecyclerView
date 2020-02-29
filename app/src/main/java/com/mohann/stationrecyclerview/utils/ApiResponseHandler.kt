package com.mohann.stationrecyclerview.utils

class ApiResponseHandler<T> private constructor(val status: Status, val data: T?, val exception: Throwable?, val warning:String?) {
    enum class Status {
        SUCCESS, ERROR, WARNING
    }

    companion object {
        fun <T> success(data: T?): ApiResponseHandler<T> {
            return ApiResponseHandler(
                Status.SUCCESS,
                data,
                null,
                null
            )
        }

        fun <T> error(exception: Throwable?): ApiResponseHandler<T> {
            return ApiResponseHandler(
                Status.ERROR,
                null,
                exception,
                null
            )
        }


        fun <T> warn(warning: String?): ApiResponseHandler<T> {
            return ApiResponseHandler(
                Status.WARNING,
                null,
                null,
                warning
            )
        }
    }
}
