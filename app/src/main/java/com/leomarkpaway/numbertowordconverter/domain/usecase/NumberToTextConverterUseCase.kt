package com.leomarkpaway.numbertowordconverter.domain.usecase

import com.leomarkpaway.numbertowordconverter.common.util.ConverterHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NumberToTextConverterUseCase @Inject constructor(
    private val converterHelper: ConverterHelper
) {
    operator fun invoke(number: Int): Flow<String> = flow {
        try {
            val convertedNumber = converterHelper.convertNumberToWords(number)
            emit(convertedNumber)
        } catch (e: Exception) { e.printStackTrace() }
    }
}