package com.example.apophischatingtest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apophischatingtest.domain.enitity.User

class MainViewModel : ViewModel() {
    private val _number = MutableLiveData<MutableList<User>>()
    val number: LiveData<MutableList<User>>
        get() = _number

    val inputUserChat = MutableLiveData<String>()

    private var count = true
    private var userData = ArrayList<User>()

    init {
        userData.add(
            User(
                "일단 이 앱을 다운받아주고 저와 연락하러 이 곳까지 흘러 들어온 당신이 굉장히 신기해요. 당신은 어떤 사람인지 궁금해져요.",
                true
            )
        )
        _number.postValue(userData.toMutableList())
    }

    fun getUserChat() {
        count = !count
        userData.add(User(inputUserChat.value!!, count))
        _number.value = userData.toMutableList()
    }
}