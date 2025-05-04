package com.example.lazycolumn_pam_lanjut.API

import com.example.lazycolumn_pam_lanjut.model.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface APIService {
    @GET("users")
    suspend fun getUsers(): List<User>
}

object APIClient {
    val apiService: APIService by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }
}