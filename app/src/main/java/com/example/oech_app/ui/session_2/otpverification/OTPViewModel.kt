package com.example.oech_app.ui.session_2.otpverification

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class OTPViewModel: ViewModel() {

    private var _codeText = List(6) { MutableStateFlow("") }
    var codeText = _codeText.map { it.asStateFlow() }

    fun onCodeChange(index: Int, text: String) {
        if (index in _codeText.indices) {
            _codeText[index].value = text
        }
    }
}