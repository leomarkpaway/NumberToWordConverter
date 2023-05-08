package com.leomarkpaway.numbertowordconverter.util

import java.util.LinkedList

fun convertNumberToWords(number: Int): String {
    if (number == 0) {
        return "zero"
    }

    val unitsArray = arrayOf("","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen")
    val tensArray = arrayOf("","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety")

    val words = LinkedList<String>()
    var num = number

    if (num >= 1000) {
        words.add(convertNumberToWords(num / 1000) + " thousand")
        num %= 1000
    }

    if (num >= 100) {
        words.add(convertNumberToWords(num / 100) + " hundred")
        num %= 100
    }

    if (num >= 20) {
        words.add(tensArray[num / 10])
        num %= 10
    }

    if (num > 0) {
        words.add(unitsArray[num])
    }

    return words.joinToString(" ")
}