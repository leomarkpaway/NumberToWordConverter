package com.leomarkpaway.numbertowordconverter.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leomarkpaway.numbertowordconverter.common.base.BaseViewModel
import com.leomarkpaway.numbertowordconverter.domain.usecase.NumberToTextConverterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val numberToTextConverterUseCase: NumberToTextConverterUseCase
) : BaseViewModel() {

    private val _wordNumber = MutableStateFlow("String number here")
    val wordNumber = _wordNumber.asStateFlow()

    suspend fun updateWordNumber(number: Int) {
        numberToTextConverterUseCase(number).onEach {
            _wordNumber.emit(it)
        }.launchIn(viewModelScope)
    }

}