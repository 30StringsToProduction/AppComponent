package ru.ozh.appcomponent.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.ozh.appcomponent.repository.Repository

class MainActivityViewModel(private val myRepository: Repository) : ViewModel() {

    val valueLiveData = MutableLiveData<Int>()
    val valuesLiveData = MutableLiveData<Array<Int>>()

    fun loadValue() {
        valueLiveData.postValue(myRepository.getSomeValue())
    }

    fun loadValues() {
        valuesLiveData.postValue(myRepository.getSomeValues())
    }

}