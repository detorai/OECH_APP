package com.example.oech_app.ui.session_2

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.oech_app.data.Users
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.binary.Base64
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.mindrot.jbcrypt.BCrypt
import java.security.SecureRandom
import kotlin.random.Random


class Session2ViewModel: ViewModel() {

    private val _userList = MutableStateFlow<List<Users>>(emptyList())
    val userList: StateFlow<List<Users>> get() = _userList


    //Name
    private val _nameText = MutableStateFlow("")
    val nameText = _nameText.asStateFlow()

    fun onNameChange(text: String){
        _nameText.value = text
    }


    //Phone
    private val _phoneText = MutableStateFlow("")
    val phoneText = _phoneText.asStateFlow()

    fun onPhoneChange(text: String){
        _phoneText.value = text
    }


    //Email
    private val _signUpEmail = MutableStateFlow("")
    val signUpEmail = _signUpEmail.asStateFlow()

    fun onSUEmailChange(text: String){
        _signUpEmail.value = text
    }

    private val _logInEmail = MutableStateFlow("")
    val logInEmail = _logInEmail.asStateFlow()

    fun onLogInEmailChange(text: String){
        _logInEmail.value = text
    }

    private val _forgotPassEmail = MutableStateFlow("")
    val forgotPassEmail = _forgotPassEmail.asStateFlow()

    fun onForPassEmailChange(text: String){
        _forgotPassEmail.value = text
    }

    fun checkEmail(email: String): Boolean{
        val emailPattern = "^[a-z0-9]+@[a-z0-9]+\\.ru$"
        val regex = Regex(emailPattern)

        return regex.matches(email)
    }


    //Password
    private val _passwordSignUp = MutableStateFlow("")
    val passwordSignUp = _passwordSignUp.asStateFlow()

    private var _passwordSUVisible = MutableStateFlow(false)
    var passwordSUVisible = _passwordSUVisible.asStateFlow()

    fun onPasswordSUChange(text: String){
        _passwordSignUp.value = text
    }
    fun onPasswordSUVisible(){
        _passwordSUVisible.value = !_passwordSUVisible.value
    }


    private val _repeatPasswordSU = MutableStateFlow("")
    val repeatPasswordSU = _repeatPasswordSU.asStateFlow()

    private var _repPasswordSUVisible = MutableStateFlow(false)
    var repPasswordSUVisible = _repPasswordSUVisible.asStateFlow()

    fun onRepPasswordSUChange(text: String){
        _repeatPasswordSU.value = text
    }
    fun onRepPasswordSUVisible(){
        _repPasswordSUVisible.value = !_repPasswordSUVisible.value
    }


    private val _passwordSignIn = MutableStateFlow("")
    val passwordSignIn = _passwordSignIn.asStateFlow()

    private var _passwordSIVisible = MutableStateFlow(false)
    var passwordSIVisible = _passwordSIVisible.asStateFlow()

    fun onPasswordSIChange(text: String){
        _passwordSignIn.value = text
    }
    fun onPasswordSIVisible(){
        _passwordSIVisible.value = !_passwordSIVisible.value
    }


    private val _passwordNew = MutableStateFlow("")
    val passwordNew = _passwordNew.asStateFlow()

    private var _passwordNewVisible = MutableStateFlow(false)
    var passwordNewVisible = _passwordNewVisible.asStateFlow()

    fun onPasswordNewChange(text: String){
        _passwordNew.value = text
    }
    fun onPasswordNewVisible(){
        _passwordNewVisible.value = !_passwordNewVisible.value
    }


    private val _repeatPasswordNew = MutableStateFlow("")
    val repeatPasswordNew = _repeatPasswordNew.asStateFlow()

    private var _repPasswordNewVisible = MutableStateFlow(false)
    var repPasswordNewVisible = _repPasswordNewVisible.asStateFlow()

    fun onRepPasswordNewChange(text: String){
        _repeatPasswordNew.value = text
    }
    fun onRepPasswordNewVisible(){
        _repPasswordNewVisible.value = !_repPasswordNewVisible.value
    }


    //CheckBox
    private var _checkedSU = MutableStateFlow(false)
    var checkedSU = _checkedSU.asStateFlow()

    fun onCheckedSUChange(state: Boolean){
        _checkedSU.value = state
    }

    private var _checkedSI = MutableStateFlow(false)
    var checkedSI = _checkedSI.asStateFlow()

    fun onCheckedSIChange(state: Boolean){
        _checkedSI.value = state
    }


    //Enabled Button (check TextFields)
    val isEnabledSignUp: Boolean
        get() = allFull(nameText, phoneText, signUpEmail, passwordSignUp, repeatPasswordSU) && checkedSU.value

    val isEnabledLogIn: Boolean
        get() = allFull(logInEmail, passwordSignIn)

    val isEnabledNewPass: Boolean
        get() = allFull(passwordNew, repeatPasswordNew)

    private fun allFull(vararg fields: StateFlow<String>): Boolean {
        return fields.all {it.value.isNotBlank()}
    }


    //Registration
    private val _regError = MutableStateFlow(false)
    val regError = _regError.asStateFlow()

    private fun genSalt(size: Int = 16): ByteArray{
        val salt = ByteArray(size)
        SecureRandom().nextBytes(salt)
        return salt
    }
    private fun hashPass(password: String, salt: ByteArray): String{
        return BCrypt.hashpw(password + Base64.isBase64(salt), BCrypt.gensalt())
    }

    fun signUp(
        name: String,
        phone: String,
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            val salt = genSalt()
            val passwordHash = hashPass(password, salt)

        val user = Users(
            name = name,
            phone = phone,
            email = email,
            password = passwordHash,
            salt = salt
        )
        if (_userList.value.any { it.email == user.email}) {
            _regError.value = true
        } else {
            _userList.value += user
            _regError.value = false
            Log.d("Session2ViewModel", "Новый пользователь зарегистрирован: $user")
            }
        }
    }


    //Log In
    fun signIn(email: String, password: String): Users? {
        val user = _userList.value.find {it.email == email && verifyPass(storedHash = it.password, salt = it.salt, password = password) }
        return user
    }

    private fun verifyPass(storedHash: String, password: String, salt: ByteArray): Boolean{
        val saltedPass = password + Base64.isBase64(salt)
        return BCrypt.checkpw(saltedPass, storedHash)
    }

    //Send OTP
    private var _codeText = List(6) { MutableStateFlow("") }
    var codeText = _codeText.map { it.asStateFlow() }

    var codeOTP = mutableStateOf<List<Int>>(emptyList())



    fun onCodeChange(index: Int, text: String) {
        if (index in _codeText.indices) {
            _codeText[index].value = text
        }
    }

    private fun genOTP(size: Int = 6, range: IntRange = 0..9): List<Int> {
        return List(size) { Random.nextInt(range.first, range.last + 1)}
    }

    fun sendOTP(email: String){
        codeOTP.value = genOTP()
        _emailForChangePass.value = email
        Log.d("OTP CODE", "email:$email\nOTP Code:${codeOTP.value.joinToString { it.toString() }}")
    }

    fun checkOTP(): Boolean {
        val enterCode = _codeText.joinToString(""){it.value}
        val otpString = codeOTP.value.joinToString("") { it.toString() }
        return enterCode == otpString
    }

    //Change User Password
    private var _emailForChangePass = MutableStateFlow("")
    var emailForChangePass = _emailForChangePass.asStateFlow()

    fun changePass (email: String, password: String){
            val user = _userList.value.find { it.email == email }
            val salt = genSalt()
            val passHash = hashPass(password, salt)
        if (!verifyPass(storedHash = user!!.password, salt = user.salt, password = password)) {
            user.password = passHash
            user.salt = salt
            Log.d("New Password", "New Pass: ${user.password}\n Users: ${userList.value}")
        }
        else {
            Log.e("Password", "Type new password")

        }
    }


    //Errors States
    private var _phoneError = MutableStateFlow(false)
    var phoneError = _phoneError.asStateFlow()

    private var _email1Error = MutableStateFlow(false)
    var email1Error = _email1Error.asStateFlow()

    private var _email2Error = MutableStateFlow(false)
    var email2Error = _email2Error.asStateFlow()

    private var _email3Error = MutableStateFlow(false)
    var email3Error = _email3Error.asStateFlow()

    private var _password1Error = MutableStateFlow(false)
    var password1Error = _password1Error.asStateFlow()

    private var _password2Error = MutableStateFlow(false)
    var password2Error = _password2Error.asStateFlow()

    private var _repPass1Error = MutableStateFlow(false)
    var repPass1Error = _repPass1Error.asStateFlow()

    private var _repPass2Error = MutableStateFlow(false)
    var repPass2Error = _repPass2Error.asStateFlow()

    private val _otpError = MutableStateFlow(false)
    val otpError = _otpError.asStateFlow()

    var checked = mutableStateOf(false)
    fun onCheckedChange(state: Boolean){
        checked.value = !checked.value
    }
}