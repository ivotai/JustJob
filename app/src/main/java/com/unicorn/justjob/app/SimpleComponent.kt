package com.unicorn.justjob.app

import android.content.Context
import com.unicorn.justjob.data.api.SimpleApi
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class SimpleComponent : KoinComponent {

    val simpleApi: SimpleApi by inject()

    val context: Context by inject()

}