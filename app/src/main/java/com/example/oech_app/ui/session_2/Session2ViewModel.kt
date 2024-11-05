package com.example.oech_app.ui.session_2

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.oech_app.data.Users
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class Session2ViewModel: ViewModel() {

    private val userList = mutableListOf<Users>()

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

    val isEnabled: Boolean
        get() = allFull() && checked.value

    private var _regError = MutableStateFlow<String?>(null)
    var regError = _regError.asStateFlow()

    private var _isSigningUp = MutableStateFlow(false)
    var isSigningUp = _isSigningUp.asStateFlow()

    fun signUp() {
        viewModelScope.launch {
            _regError.value = null

        if (!checkEmail(emailText.value)){
            _regError.value = "Некорректный адрес почты"
        }

        val user = Users(
            name = nameText.value,
            phone = phoneText.value,
            email = emailText.value,
            password = passwordText.value
        )
        if (!allFull()){
            _regError.value = "Пожалуйста, заполните все поля"
        }
        if (userList.any { it.email == user.email}) {
            _regError.value = "Пользователь с таким email уже зарегистрирован."
        } else {
            userList.add(user)
            _regError.value = null
            _isSigningUp.value = true
            }
        }
    }
    fun signIn(email: String, password: String): Users?{
        return userList.find { it.email == email && it.password == password }
    }


    private fun allFull(): Boolean {
        return nameText.value.isNotBlank() &&
                phoneText.value.isNotBlank() &&
                emailText.value.isNotBlank() &&
                passwordText.value.isNotBlank() &&
                repeatPasswordText.value.isNotBlank()
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
    private fun checkEmail(email: String): Boolean{
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