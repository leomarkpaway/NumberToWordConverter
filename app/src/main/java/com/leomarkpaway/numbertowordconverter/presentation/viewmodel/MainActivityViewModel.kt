package com.leomarkpaway.numbertowordconverter.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.leomarkpaway.numbertowordconverter.common.base.BaseViewModel
import com.leomarkpaway.numbertowordconverter.domain.usecase.NumberToTextConverterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val numberToTextConverterUseCase: NumberToTextConverterUseCase
) : BaseViewModel() {

    private val _wordNumber = MutableStateFlow("String number here")
    val wordNumber = _wordNumber.asStateFlow()

    suspend fun updateWordNumber(number: Int) {
        numberToTextConverterUseCase(number).map { _wordNumber.emit(it) }.launchIn(viewModelScope)
    }

}