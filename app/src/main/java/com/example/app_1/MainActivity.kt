package com.example.app_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_list)

        recyclerView = findViewById(R.id.rv)

        val dataList = getUserList()

        showUsers(dataList)
    }

    fun showUsers(dataList: List<User>){
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = UserAdapter(dataList)
        recyclerView.adapter = adapter
    }

    fun getUserList() : List<User> {
        val userList = mutableListOf<User>()
        userList.add(User("1", "Mehedi Hassan"))
        userList.add(User("2", "Tapojit Chandra Paul"))
        userList.add(User("3", "Ishtiaq Islam"))
        userList.add(User("4", "Mofakkharul Islam"))
        userList.add(User("5", "Sayma Mahjuba"))
        userList.add(User("6", "Tanha Kabir"))
        userList.add(User("7", "Sumaiya Sultana"))
        userList.add(User("8", "Tasnuva Rohin"))

        return userList
    }
}