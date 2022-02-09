package com.example.app_1.network

import com.example.app_1.model.Comment
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("comments")
    fun getComments() : Call<List<Comment>>
}