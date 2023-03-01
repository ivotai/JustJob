package com.unicorn.justjob.app.module

import com.unicorn.justjob.data.api.SimpleApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    single {

        get<Retrofit>().create(SimpleApi::class.java)

    }

}