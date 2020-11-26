package com.example.userviewmodelmvvm.view.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Demo2Model : ViewModel() {

    companion object {
       val linkNumber = MutableLiveData<Int>(0)
    }


    fun getLinkNumber(): MutableLiveData<Int> {
        return linkNumber
    }

    fun addLinkNumber(n: Int) {
        linkNumber.value = linkNumber.value?.plus(n)
    }

    fun reduceLinkNumber(n: Int) {
        linkNumber.value = linkNumber.value?.minus(n)
    }
}