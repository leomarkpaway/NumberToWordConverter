package com.leomarkpaway.numbertowordconverter.viewmodel

import androidx.lifecycle.ViewModel
import com.leomarkpaway.numbertowordconverter.util.convertNumberToWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainActivityViewModel : ViewModel() {

    private val _wordNumber = MutableStateFlow("String number here")
    val wordNumber = _wordNumber.asStateFlow()

    suspend fun updateWordNumber(number: Int?) {
        _wordNumber.emit(convertNumberToWords(number ?: -1))
    }

}