package com.unicorn.justjob.ui

import com.blankj.utilcode.util.ToastUtils
import com.drake.brv.utils.divider
import com.drake.brv.utils.linear
import com.drake.brv.utils.setup
import com.unicorn.justjob.R
import com.unicorn.justjob.data.DataProvider
import com.unicorn.justjob.data.model.Person
import com.unicorn.justjob.databinding.FraListBinding
import com.unicorn.justjob.databinding.ItemPersonBinding
import com.unicorn.justjob.ui.base.BaseFra

class ListFra : BaseFra<FraListBinding>(FraListBinding::inflate) {

    override fun init() {
        doMyThings()
    }

    private fun doMyThings() = with(binding) {
        val adapter = rv.linear().divider(R.drawable.divider).setup {
            addType<Person>(R.layout.item_person)
            onClick(R.id.tvName) {
                val item = getModel<Person>()
                ToastUtils.showShort(item.name)
            }
            onBind {
                getBinding<ItemPersonBinding>().apply {
                    val item = getModel<Person>()
                    tvName.text = item.name
                }
            }
        }
        adapter.models = DataProvider().provide()
    }

}