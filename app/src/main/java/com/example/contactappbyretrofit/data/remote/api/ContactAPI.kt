package com.example.contactappbyretrofit.data.remote.api


import com.example.contactappbyretrofit.data.remote.request.ContactAddData
import com.example.contactappbyretrofit.data.remote.response.ContactData
import com.example.contactappbyretrofit.data.remote.request.ContactEditData
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface ContactAPI {

    @GET("api/v1/contact")
    fun getAllContacts(): Call<List<ContactData>>

    @PUT("api/v1/contact")
    fun editContact(contactEditData: ContactEditData): Call<Unit>

    @POST("api/v1/contact")
    fun addContact(contactAddData: ContactAddData): Call<ContactData>

    @DELETE("api/v1/contact")
    fun deleteContact(@Query("id") id: Int): Call<Unit>
}