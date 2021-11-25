package com.udacity.shoestore.models

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {
    private val logEmail:String="mostafa.n3ma@gmail.com"
    private val logPassword:String="12345"
     val email= MutableLiveData<String>()
     val password= MutableLiveData<String>()
    private val _event_login_successfully=MutableLiveData<Boolean>()
    val event_login_successfully:LiveData<Boolean>get() = _event_login_successfully
       init {
           _event_login_successfully.value=false
       }
    fun logUser(){
        if (email.value!!.isEmpty()||password.value!!.isEmpty()){
        }else{
            if (email.value.equals(logEmail)){
                if (password.value.equals(logPassword)){
                    _event_login_successfully.value=true
                }else{
                }
            }else{
            }
        }
    }
    fun login_completed(){
        _event_login_successfully.value=false
    }


}