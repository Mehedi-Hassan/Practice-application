package com.example.app_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_1.model.Comment
import com.example.app_1.network.NetworkCallback
import com.example.app_1.network.NetworkClient

class MainActivity : AppCompatActivity(), NetworkCallback {
    private lateinit var recyclerView: RecyclerView
    private val networkClient = NetworkClient(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_list)

        recyclerView = findViewById(R.id.rv)
        networkClient.getComment()
    }

    fun showData(dataList: List<Comment>){
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = CommentAdapter(dataList)
        recyclerView.adapter = adapter
    }

    override fun getList(commentList: List<Comment>) {
        showData(commentList)
    }
}