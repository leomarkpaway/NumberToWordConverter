package com.leomarkpaway.numbertowordconverter.presentation.ui

import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.leomarkpaway.numbertowordconverter.R
import com.leomarkpaway.numbertowordconverter.common.base.BaseActivity
import com.leomarkpaway.numbertowordconverter.databinding.ActivityMainBinding
import com.leomarkpaway.numbertowordconverter.presentation.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>() {

    override val layoutId = R.layout.activity_main
    override val viewModel: MainActivityViewModel by viewModels()

    override fun initViews() {
        super.initViews()
        getUserInput()
    }

    override fun subscribe() {
        super.subscribe()
        displayConvertedNumber()
    }

    private fun getUserInput() = with(binding) {
        edtNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                lifecycleScope.launch {
                    s.toString().toIntOrNull()?.let { viewModel.updateWordNumber(it) }
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