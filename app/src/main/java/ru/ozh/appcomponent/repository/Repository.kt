package ru.ozh.appcomponent.repository

class Repository {

    fun getSomeValue() = 42

    fun getSomeValues() = Array(10) { i: Int ->  i * 2 }
}