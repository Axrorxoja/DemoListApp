package com.example.axrorxoja.demolistapp.entity.main

class MainResponse(
    val searchSessionId: String,
    val users: Array<User> = emptyArray()
)