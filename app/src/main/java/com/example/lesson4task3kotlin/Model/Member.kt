package com.example.lesson4task3kotlin.Model

import java.io.Serializable

class Member(var name: String, var age: Int) : Serializable {

    fun Member(name: String?, age: Int) {
        if (name != null) {
            this.name = name
        }
        this.age = age
    }

    override fun toString(): String {
        return "member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}'
    }
}