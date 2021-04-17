package com.example.onepopote

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.onepopote.ui.*
import java.lang.Integer.parseInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            OnePopoteTheme {
                Scaffold() {
                    // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colors.background) {
                        Column (
                            verticalArrangement = Arrangement.Bottom,
                            modifier = Modifier.fillMaxSize()
                        ) {

                            var pasta by remember { mutableStateOf("") }
                            var acqua = 0;

                            try {
                                acqua = (parseInt(pasta) * 540) / 227;
                            }
                            catch (e: NumberFormatException) {
                                acqua = 0;
                            }

                            Column() {
                                Row (modifier = Modifier.weight(3f),
                                    verticalAlignment = Alignment.CenterVertically) {
                                    BigDisplayer(acqua)
                                }
                                Row (modifier = Modifier.weight(1f)
                                ) {
                                    Surface(modifier = Modifier.fillMaxSize(), color = dark200, shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)) {
                                        Column() {
                                            Text("CUSTOMIZE", letterSpacing = 2.sp, modifier = Modifier.padding(15.dp), color = dark900)

                                            Row(modifier = Modifier
                                                .fillMaxSize()
                                                .padding(bottom = 25.dp), horizontalArrangement = Arrangement.Center) {
                                                TextField(
                                                    value = pasta,
                                                    onValueChange = { if (it.length < 5 ) pasta = it },
                                                    label = { Text("Pasta (g)") },
                                                    shape = RoundedCornerShape(30.dp),
                                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                                    colors = TextFieldDefaults.textFieldColors(
                                                        focusedIndicatorColor = Transparent,
                                                        disabledIndicatorColor = Transparent,
                                                        unfocusedIndicatorColor = Transparent,
                                                        backgroundColor = dark400,
                                                    ),
                                                    modifier =  Modifier.padding(all = 16.dp).fillMaxWidth()
                                                )
                                            }

                                        }
                                    }
                                }

                            }

                        }
                    }
                }

            }
        }
    }
}

@Composable
fun BigDisplayer(acqua : Int = 0) {
    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        Text(text = acqua.toString(), fontSize = 18.em)
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = "ml")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OnePopoteTheme {
        BigDisplayer(10)
    }
}