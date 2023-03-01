package com.unicorn.justjob.data

import com.unicorn.justjob.data.model.Person

class DataProvider {

    fun provide(): List<Person> {
        val list = ArrayList<Person>()
        for (i in 1..20) {
            Person(name = "name $i").let { list.add(it) }
        }
        return list
    }

}