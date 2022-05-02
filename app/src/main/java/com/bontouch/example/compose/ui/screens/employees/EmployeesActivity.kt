package com.bontouch.example.compose.ui.screens.employees

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bontouch.example.compose.R
import com.bontouch.example.compose.config.SettingsRepository
import com.bontouch.example.compose.ui.theme.BontouchBlue

@ExperimentalAnimationApi
class EmployeesActivity : ComponentActivity() {
    private val viewModel: EmployeesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window?.statusBarColor = Color.Black.toArgb()
            EmployeesScreen(viewModel = viewModel)
        }
    }

    @Composable
    fun TextInputSample() {

        var textContents ="default text"

        OutlinedTextField(
            label = {
                Text(color = Color.White, text = "Input text here:")
            },
            value = textContents,
            onValueChange = {
                textContents = it
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.White
            )
        )
    }

    @Composable
    fun JfokusExample2() {
        Column(modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
            .padding(8.dp)
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black
                ),
                onClick = { /* ... */ }
            ) {
                Column {
                    Text("Click me!", color = Color.White)
                    Image(
                        painter = painterResource(R.drawable.bontouch_logo_white),
                        contentDescription = null
                    )
                }
            }
        }
    }

    @Composable
    fun JfokusExample1() {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(8.dp)
        ) {
            for (i in 1..5) {
                if (i != 3) {
                    JfokusHello(
                        index = i,
                        modifier = Modifier
                            .background(Color.Black)
                            .padding(start = 16.dp, end = 16.dp)
                    )
                }
            }
        }
    }

    @Composable
    fun JfokusHello(index: Int, modifier: Modifier = Modifier) {
        Text(
            modifier = modifier,
            text = "Hello, Jfokus $index!",
            style = MaterialTheme.typography.h6,
            color = Color.White
        )
    }

    override fun onBackPressed() {
        viewModel.onBackPressed()
    }
}
