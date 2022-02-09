package com.example.app_1.network

import com.example.app_1.model.Comment

interface NetworkCallback {
    fun getList(commentList: List<Comment>)
}