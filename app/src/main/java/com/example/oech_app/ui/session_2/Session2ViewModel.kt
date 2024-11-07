package com.example.oech_app.ui.session_2

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.oech_app.data.Users
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class Session2ViewModel: ViewModel() {

    private val _userList = MutableStateFlow<List<Users>>(emptyList())
    val userList: StateFlow<List<Users>> get() = _userList

    private val _nameText = MutableStateFlow("")
    val nameText = _nameText.asStateFlow()

    private val _phoneText = MutableStateFlow("")
    val phoneText = _phoneText.asStateFlow()

    private val _emailText = MutableStateFlow("")
    val emailText = _emailText.asStateFlow()

    private val _passwordText = MutableStateFlow("")
    val passwordText = _passwordText.asStateFlow()

    private var _passwordVisible = MutableStateFlow(false)
    var passwordVisible = _passwordVisible.asStateFlow()

    private val _repeatPasswordText = MutableStateFlow("")
    val repeatPasswordText = _repeatPasswordText.asStateFlow()

    private var _repPasswordVisible = MutableStateFlow(false)
    var repPasswordVisible = _repPasswordVisible.asStateFlow()

    private var _checked = MutableStateFlow(false)
    var checked = _checked.asStateFlow()

    private var _codeText = List(6) { MutableStateFlow("") }
    var codeText = _codeText.map { it.asStateFlow() }

    val isEnabledSignUp: Boolean
        get() = allFull(nameText, phoneText, emailText, passwordText, repeatPasswordText) && checked.value

    val isEnabledLogIn: Boolean
        get() = allFull(emailText, passwordText)

    private val _regError = MutableStateFlow(false)
    val regError = _regError.asStateFlow()

    fun signUp() {
        viewModelScope.launch {

        val user = Users(
            name = nameText.value,
            phone = phoneText.value,
            email = emailText.value,
            password = passwordText.value
        )
        if (_userList.value.any { it.email == user.email}) {
            _regError.value = true
        } else {
            _userList.value += user
            _regError.value = false
            Log.d("Session2ViewModel", "Новый пользователь зарегистрирован: $user")
            Log.d("Session2ViewModel", "Текущий список пользователей: ${_userList.value}")
            }
        }
    }
    fun signIn(email: String, password: String): Users?{
        Log.d("Session2ViewModel", "Текущий список пользователей: ${_userList.value}")
        val user = _userList.value.find {
            Log.d("Session2ViewModel", "Проверка пользователя: email=${it.email}, пароль=${it.password}")
            it.email == email && it.password == password }
        Log.d("Session2ViewModel", "Попытка входа пользователем: $email. Успех: ${user != null}")
        return user
    }


    private fun allFull(vararg fields: StateFlow<String>): Boolean {
        return fields.all {it.value.isNotBlank()}
    }

    fun onNameChange(text: String){
        _nameText.value = text
    }


    fun onPhoneChange(text: String){
        _phoneText.value = text
    }


    fun onEmailChange(text: String){
        _emailText.value = text
    }
    fun checkEmail(email: String): Boolean{
        val emailPattern = "^[a-z0-9]+@[a-z0-9]+\\.ru$"
        val regex = Regex(emailPattern)

        return regex.matches(email)
    }


    fun onPasswordChange(text: String){
        _passwordText.value = text
    }
    fun onPasswordVisible(){
        _passwordVisible.value = !_passwordVisible.value
    }


    fun onRepPasswordChange(text: String){
        _repeatPasswordText.value = text
    }
    fun onRepPasswordVisible(){
        _repPasswordVisible.value = !_repPasswordVisible.value
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