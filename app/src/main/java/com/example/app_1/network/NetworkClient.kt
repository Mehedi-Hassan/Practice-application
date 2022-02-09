package com.example.app_1.network

import com.example.app_1.model.Comment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkClient(val networkCallback: NetworkCallback) {

    var commentList: List<Comment> = mutableListOf()

    fun getComment(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiInterface = retrofit.create(ApiInterface::class.java)
        apiInterface.getComments().enqueue(object : Callback<List<Comment>>{
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                if(response.isSuccessful){
                    val body = response.body()
                    if(body != null){
                        commentList = body
                        networkCallback.getList(commentList)
                    }
                }
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                // TODO("Not yet implemented")
            }

        })

    }
}