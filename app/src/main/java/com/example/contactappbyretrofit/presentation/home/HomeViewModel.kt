package com.example.contactappbyretrofit.presentation.home

import androidx.lifecycle.MutableLiveData
import com.example.contactappbyretrofit.data.remote.api.ContactAPI
import com.example.contactappbyretrofit.data.remote.client.ContactClient
import com.example.contactappbyretrofit.data.remote.request.ContactAddData
import com.example.contactappbyretrofit.data.remote.response.ContactData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel {
    val mutableList = MutableLiveData<List<ContactData>>()
    private val api = ContactClient.retrofit.create(ContactAPI::class.java)
    val error = MutableLiveData<Boolean>()


    fun loadData() {
        error.value = true
        api.getAllContacts().enqueue(object : Callback<List<ContactData>>{
           override fun onResponse(
               call: Call<List<ContactData>>,
               response: Response<List<ContactData>>
           ) {
               error.value = false
               if(response.isSuccessful) {
                   response.body()?.let {
                       mutableList.value = it
                   }
               }

           }

           override fun onFailure(call: Call<List<ContactData>>, t: Throwable) {

           }

       })
//            error.value =
    }

    fun addData(contact: ContactAddData) {
        api.addContact(contact).enqueue(object : Callback<ContactData>{
            override fun onResponse(call: Call<ContactData>, response: Response<ContactData>) {
                if (response.isSuccessful) {
                    loadData()
                }
            }

            override fun onFailure(call: Call<ContactData>, t: Throwable) {

            }

        })
    }
}
