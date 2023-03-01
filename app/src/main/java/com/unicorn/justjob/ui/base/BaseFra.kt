package com.unicorn.justjob.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.unicorn.justjob.app.SimpleComponent


abstract class BaseFra<VB : ViewBinding>(
    inflate: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : BaseBindingFragment<VB>(inflate) {

    val simpleApi by lazy { SimpleComponent().simpleApi }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    abstract fun init()

}