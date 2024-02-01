package com.example.contactappbyretrofit.data.remote.request

data class ContactAddData(
    val id: Long,
    val firstName:String,
    val lastName:String,
    val phoneNumber: String
)