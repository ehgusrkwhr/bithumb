package com.kdh.mvvmbithumb.data

sealed class Resource<out T : Any>{
    class Success<T : Any>(val data : T) : Resource<T>()
    class Error(val message : String?) : Resource<Nothing>()
}
