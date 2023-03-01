package com.unicorn.justjob.app

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.drake.statelayout.StateConfig
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.unicorn.justjob.R
import com.unicorn.justjob.app.module.apiModule
import com.unicorn.justjob.app.module.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SimpleApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        fun startKoin(context: Context) {
            startKoin {
                androidContext(this@SimpleApplication.applicationContext)
                modules(networkModule, apiModule)
            }
        }
        startKoin(this)

        fun initStateConfig() {
            StateConfig.apply {
                emptyLayout = R.layout.layout_empty
                errorLayout = R.layout.layout_error
                loadingLayout = R.layout.layout_loading
            }
        }
        initStateConfig()

        fun initSmartRefreshLayout() {
            SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout ->
                ClassicsFooter(
                    this
                )
            }
        }
        initSmartRefreshLayout()
    }


}


