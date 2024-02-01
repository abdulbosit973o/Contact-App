package com.example.contactappbyretrofit.domain

class AppRepositoryImpl : AppRepository {
    companion object {
        private lateinit var instance : AppRepository
        fun getInstance(): AppRepository {
            if(!(::instance.isInitialized)) instance = AppRepositoryImpl()
            return instance
        }
    }


}