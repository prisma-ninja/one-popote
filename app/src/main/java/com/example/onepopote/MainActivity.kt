package com.example.onepopote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.ui.tooling.preview.Preview
import com.example.onepopote.ui.OnePopoteTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnePopoteTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column (modifier = Modifier.fillMaxSize()) {
                        Calculator()
                    }
                }
            }
        }
    }
}

@Composable
fun Calculator() {
    //Text(text = "Hello $name!")
    //var name = remember { mutableStateOf("") }
    var pasta by remember { mutableStateOf("") }
    OutlinedTextField(
        value = pasta,
        onValueChange = { pasta = it },
        keyboardType = KeyboardType.Number,
        imeAction = ImeAction.Done,
        label = { Text("Pasta (g)") }
    )
    var acqua = 0;
    if (pasta.isNotEmpty()) {
        acqua = (pasta.toInt() * 540) / 227;
    }
    Text(
        text = "Acqua $acqua ml",
        style = MaterialTheme.typography.h5
    )

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OnePopoteTheme {
        Calculator()
    }
}