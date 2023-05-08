package com.leomarkpaway.numbertowordconverter.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.leomarkpaway.numbertowordconverter.databinding.ActivityMainBinding
import com.leomarkpaway.numbertowordconverter.viewmodel.MainActivityViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainActivityViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getUserInput()
        displayConvertedNumber()
    }

    private fun getUserInput() = with(binding) {
        edtNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                lifecycleScope.launch {
                    viewModel.updateWordNumber(s.toString().toIntOrNull())
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })
    }

    private fun displayConvertedNumber() {
        lifecycleScope.launch {
            viewModel.wordNumber.collectLatest { binding.tvNumber.text = it }
        }
    }

}