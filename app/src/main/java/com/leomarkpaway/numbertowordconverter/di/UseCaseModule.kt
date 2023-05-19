package com.leomarkpaway.numbertowordconverter.di

import com.leomarkpaway.numbertowordconverter.domain.usecase.NumberToTextConverterUseCase
import com.leomarkpaway.numbertowordconverter.common.util.ConverterHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideNumberConverter(converterHelper: ConverterHelper) = NumberToTextConverterUseCase(converterHelper)
}