package com.unicorn.justjob.data.model

// LoginResponse 比较特别，不继承自 Response。
data class LoginResponse(
    val loginToken: String,
    val session: String,
    val success: Boolean,
    val user: User,
    val message: String,
    val weakCipher: Boolean = false
)

data class User(
    val id: Long,
    val roleTag: String,
    val roles: List<String>,
    val username: String,
    val courtName: String,
    var department: String
)