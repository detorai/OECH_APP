package com.example.oech_app

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.oech_app.data.ColorsScheme
import com.example.oech_app.data.Users
import com.example.oech_app.ui.theme.TextLighter
import com.example.oech_app.ui.theme.primaryDark
import com.example.oech_app.ui.theme.secondaryDark
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.binary.Base64
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.mindrot.jbcrypt.BCrypt
import java.security.SecureRandom
import kotlin.random.Random

class OechAppViewModel: ViewModel() {

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




    //Session 3

    private var _checked = MutableStateFlow(false)
    var checked = _checked.asStateFlow()
    fun onCheckedChange(state: Boolean){
        _checked.value = !_checked.value
    }

    fun getColors(checked: Boolean): ColorsScheme{
        return if (checked) {
            ColorsScheme(
                mainColor = primaryDark,
                secondaryColor = secondaryDark,
                textColor = Color.White
            )
        } else {
            ColorsScheme(
                mainColor = Color.White,
                secondaryColor = Color.White,
                textColor = TextLighter
            )
        }
    }

    private var _addressO = MutableStateFlow("")
    var addressO = _addressO.asStateFlow()

    fun onAddressO(address: String){
        _addressO.value = address
    }


    private var _countryO = MutableStateFlow("")
    var countryO = _countryO.asStateFlow()

    fun onCountryO(country: String){
        _countryO.value = country
    }


    private var _phoneO = MutableStateFlow("")
    var phoneO = _phoneO.asStateFlow()

    fun onPhoneO(phone: String){
        _phoneO.value = phone
    }


    private var _othersO = MutableStateFlow("")
    var othersO = _othersO.asStateFlow()

    fun onOthersO(others: String){
        _othersO.value = others
    }

    private var _addressD1 = MutableStateFlow("")
    var addressD1 = _addressD1.asStateFlow()

    fun onAddressD1(address: String){
        _addressD1.value = address
    }


    private var _countryD1 = MutableStateFlow("")
    var countryD1 = _countryD1.asStateFlow()

    fun onCountryD1(country: String){
        _countryD1.value = country
    }


    private var _phoneD1 = MutableStateFlow("")
    var phoneD1 = _phoneD1.asStateFlow()

    fun onPhoneD1(phone: String){
        _phoneD1.value = phone
    }


    private var _othersD1 = MutableStateFlow("")
    var othersD1 = _othersD1.asStateFlow()

    fun onOthersD1(others: String){
        _othersD1.value = others
    }

    private var _addressD2 = MutableStateFlow("")
    var addressD2 = _addressD2.asStateFlow()

    fun onAddressD2(address: String){
        _addressD2.value = address
    }


    private var _countryD2 = MutableStateFlow("")
    var countryD2 = _countryD2.asStateFlow()

    fun onCountryD2(country: String){
        _countryD2.value = country
    }


    private var _phoneD2 = MutableStateFlow("")
    var phoneD2 = _phoneD2.asStateFlow()

    fun onPhoneD2(phone: String){
        _phoneD2.value = phone
    }


    private var _othersD2 = MutableStateFlow("")
    var othersD2 = _othersD2.asStateFlow()

    fun onOthersD2(others: String){
        _othersD2.value = others
    }

    private var _itemsP = MutableStateFlow("")
    var itemsP = _itemsP.asStateFlow()

    fun onItemsP(items: String){
        _itemsP.value = items
    }


    private var _weightP = MutableStateFlow("")
    var weightP = _weightP.asStateFlow()

    fun onWeightP(weight: String){
        _weightP.value = weight
    }


    private var _worthP = MutableStateFlow("")
    var worthP = _worthP.asStateFlow()

    fun onWorthP(worth: String){
        _worthP.value = worth
    }

    private val _trackNum = MutableStateFlow("")
    val trackNum = _trackNum.asStateFlow()

    private val _loaded = MutableStateFlow(false)
    val loaded = _loaded.asStateFlow()

    @OptIn(DelicateCoroutinesApi::class)
    fun transSuccessful(){
        GlobalScope.launch {
            delay(5000)
            _loaded.value = true
        }
    }

    fun trackNumRandom(): String{
        val random = Random(System.currentTimeMillis())

        val part1 = (1000..9999).random(random).toString()
        val part2 = (1000..9999).random(random).toString()
        val part3 = (1000..9999).random(random).toString()
        val part4 = (1000..9999).random(random).toString()

        val trackNum = "R-$part1-$part2-$part3-$part4"
        _trackNum.value = trackNum
        return _trackNum.value
    }

    private val _addDest = MutableStateFlow(false)
    val addDest = _addDest.asStateFlow()

    fun addDestination(){
        _addDest.value = !_addDest.value
    }
    private var _tabState = MutableStateFlow(true)
    var tabState = _tabState.asStateFlow()

    private var _selectedTabIndex = MutableStateFlow(0)
    var selectedTabIndex = _selectedTabIndex.asStateFlow()

    fun changeSelect(index: Int){
        _selectedTabIndex.value = index
    }

    private val _balance = MutableStateFlow("")
    val balance = _balance.asStateFlow()

    fun makeBalance(): String{
        val random = Random(System.currentTimeMillis())

        val startBalance = (500..100000).random(random).toString()

        val balance = "N${startBalance}"
        _balance.value = balance
        return _balance.value
    }

    private val hideBalance = "*******"

    fun hidingBalance(state: Boolean, balance: String): String{

        var myBalance = ""

        myBalance = if (!state){
            balance
        } else {
            hideBalance
        }
        return myBalance
    }

    private val _balanceState = MutableStateFlow(false)
    val balanceState = _balanceState.asStateFlow()

    fun onClickBalance(){
        _balanceState.value = !balanceState.value
    }
    private var _choose = MutableStateFlow(1)
    var choose = _choose.asStateFlow()

    fun changePayMeth(index: Int){
        _choose.value = index
    }
    private var _othChoose = MutableStateFlow(1)
    var othChoose = _othChoose.asStateFlow()

    fun changeCard(index: Int){
        _othChoose.value = index
    }

    private val _trackState1 = MutableStateFlow(false)
    val trackState1 = _trackState1.asStateFlow()

    fun onTrackState1(state: Boolean){
        _trackState1.value = !_trackState1.value
    }

    private val _trackState2 = MutableStateFlow(false)
    val trackState2 = _trackState2.asStateFlow()

    fun onTrackState2(state: Boolean){
        _trackState2.value = !_trackState2.value
    }

    private val _trackState3 = MutableStateFlow(false)
    val trackState3 = _trackState3.asStateFlow()

    fun onTrackState3(state: Boolean){
        _trackState3.value = !_trackState3.value
    }

    private val _trackState4 = MutableStateFlow(false)
    val trackState4 = _trackState4.asStateFlow()

    fun onTrackState4(state: Boolean){
        _trackState4.value = !_trackState4.value
    }
}