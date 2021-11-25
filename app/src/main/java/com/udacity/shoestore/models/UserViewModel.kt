package com.udacity.shoestore.models

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    private val logEmail: String = "mostafa.n3ma@gmail.com"
    private val logPassword: String = "12345"
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    private val _event_login_successfully = MutableLiveData<Boolean>()
    val event_login_successfully: LiveData<Boolean> get() = _event_login_successfully

    private val _event_empty_field = MutableLiveData<Boolean>()
    val event_empty_field: LiveData<Boolean> get() = _event_empty_field

    private val _event_wrong_email = MutableLiveData<Boolean>()
    val event_wrong_email: LiveData<Boolean> get() = _event_wrong_email

    private val _event_wrong_password = MutableLiveData<Boolean>()
    val event_wrong_password: LiveData<Boolean> get() =_event_wrong_password



    init {
        _event_login_successfully.value = false
        _event_empty_field.value = false
        _event_wrong_email.value=false
        _event_wrong_password.value=false
    }

    fun logUser() {
        try {
            if (email.value==null || password.value==null) {
                _event_empty_field.value = true
                _event_empty_field.value=false
            } else {
                if (email.value.equals(logEmail)) {
                    if (password.value.equals(logPassword)) {
                        _event_login_successfully.value = true
                    } else {
                        _event_wrong_password.value=true
                        _event_wrong_password.value=false
                    }
                } else {
                    _event_wrong_email.value=true
                    _event_wrong_email.value=false
                }
            }
        } catch (e: Exception) {
            Log.i("empty_field", "logUser: ${e.message}")
        }
    }

    fun login_completed() {
        _event_login_successfully.value = false
    }


}