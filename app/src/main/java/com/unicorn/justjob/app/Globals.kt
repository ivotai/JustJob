package com.unicorn.justjob.app

import com.unicorn.justjob.data.model.LoginResponse
import com.unicorn.justjob.data.model.User

object Globals {

    val session: String get() = loginResponse.session
    val token: String get() = loginResponse.loginToken
    val user: User get() = loginResponse.user

    lateinit var loginResponse: LoginResponse

}