package com.example.apophischatingtest

import android.util.Log
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apophischatingtest.databinding.ActivityMainBinding

class MainViewModel: ViewModel() {
    private val _number = MutableLiveData<ArrayList<User>>()

    val number: LiveData<ArrayList<User>>
        get() = _number

    val inputUserChat = MutableLiveData<String>()

    private var count = 0
    private var UserData = ArrayList<User>()

    init {
        UserData.add(User("일단 이 앱을 다운받아주고 저와 연락하러 이 곳까지 흘러 들어온 당신이 굉장히 신기해요. 당신은 어떤 사람인지 궁금해져요.",0))
        _number.postValue(UserData)
    }

    fun increaseNumber() {
        count += 1
        UserData.add(User(count.toString(),count%2))
        _number.value = UserData
    }

    fun getUserChat() {
        count += 1
        UserData.add(User(inputUserChat.value!!, count%2))
        _number.value = UserData
    }
}