package com.example.lesson4task3kotlin.Model

import java.io.Serializable

class User(private var name: String, private var age: Int) : Serializable {

    fun User(name: String?, age: Int) {
        if (name != null) {
            this.name = name
        }
        this.age = age
    }

    override fun toString(): String {
        return "user{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}'
    }
    }
