package com.unicorn.justjob.ui

import com.rxjava.rxlife.lifeOnMain
import com.unicorn.justjob.app.Globals
import com.unicorn.justjob.databinding.FraLoginBinding
import com.unicorn.justjob.ui.act.MainAct
import com.unicorn.justjob.ui.base.BaseFra
import splitties.activities.start


class LoginFra : BaseFra<FraLoginBinding>(FraLoginBinding::inflate) {

    override fun init() {
        login()
    }

    private fun login() {
        binding.state.apply {
            val username = "13611840424"
            val password = "H2A!uK6y"
            showLoading()
            simpleApi.login(username = username, password = password).lifeOnMain(this@LoginFra)
                .subscribe({
                    if (it.success) {
                        showContent()
                        Globals.loginResponse = it
                        requireActivity().start<MainAct>()
                        requireActivity().finish()
                    } else {
                        showError(it.message)
                    }

                }, {
                    showError(it)
                })
        }
    }

}