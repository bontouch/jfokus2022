package com.bontouch.example.compose.ui.screens.employees

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi

@ExperimentalAnimationApi
class EmployeesActivity : ComponentActivity() {
    private val viewModel: EmployeesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmployeesScreen(viewModel = viewModel)
        }
    }

    override fun onBackPressed() {
        viewModel.onBackPressed()
    }
}
