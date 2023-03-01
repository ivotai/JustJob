package com.unicorn.justjob.helper

import com.unicorn.justjob.app.Cookie
import com.unicorn.justjob.app.Globals
import com.unicorn.justjob.app.SESSION
import com.unicorn.justjob.app.SimpleComponent
import okhttp3.Interceptor
import okhttp3.Response

object NetworkHelper {

    fun proceedRequestWithNewSession(chain: Interceptor.Chain): Response {
        // session 过期时使用 token 登录，获取新的 session 和 token。
        SimpleComponent().simpleApi.loginSilently().execute().body().let { Globals.loginResponse = it!! }
        return proceedRequestWithSession(chain)
    }

    //
    fun proceedRequestWithSession(chain: Interceptor.Chain): Response {
        return chain.request().newBuilder().removeHeader(Cookie)
            .addHeader(Cookie, "${SESSION}=${Globals.session}").build().let { chain.proceed(it) }
    }

}