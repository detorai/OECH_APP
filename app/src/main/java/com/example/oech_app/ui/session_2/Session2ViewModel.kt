package com.example.oech_app.ui.session_2

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class Session2ViewModel: ViewModel() {

    private val _nameText = MutableStateFlow("")
    val nameText = _nameText.asStateFlow()

    private val _phoneText = MutableStateFlow("")
    val phoneText = _phoneText.asStateFlow()

    private val _emailText = MutableStateFlow("")
    val emailText = _emailText.asStateFlow()

    private val _passwordText = MutableStateFlow("")
    val passwordText = _passwordText.asStateFlow()

    private val _repeatPasswordText = MutableStateFlow("")
    val repeatPasswordText = _repeatPasswordText.asStateFlow()

    private var _checked = MutableStateFlow(false)
    var checked = _checked.asStateFlow()

    private var _codeText = List(6) { MutableStateFlow("") }
    var codeText = _codeText.map { it.asStateFlow() }

    fun onNameChange(text: String){
        _nameText.value = text
    }
    fun onPhoneChange(text: String){
        _phoneText.value = text
    }
    fun onEmailChange(text: String){
        _emailText.value = text
    }
    fun onPasswordChange(text: String){
        _passwordText.value = text
    }
    fun onRepPasswordChange(text: String){
        _repeatPasswordText.value = text
    }
    fun onCheckedChange(state: Boolean){
        _checked.value = state
    }
    fun onCodeChange(index: Int, text: String) {
        if (index in _codeText.indices) {
            _codeText[index].value = text
        }
    }
}