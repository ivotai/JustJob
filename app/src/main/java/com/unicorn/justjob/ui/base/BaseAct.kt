package com.unicorn.justjob.ui.base;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.unicorn.justjob.R


abstract class BaseAct(private val fragmentClass: Class<out Fragment>) :
    AppCompatActivity(R.layout.act_frag_wrapper) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().setReorderingAllowed(true)
                .add(R.id.fragmentContainerView, fragmentClass, intent.extras).commit()
        }
    }

}