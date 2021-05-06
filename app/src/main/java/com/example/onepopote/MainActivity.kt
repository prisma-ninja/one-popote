package com.example.onepopote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.onepopote.ui.*
import java.lang.Integer.parseInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            OnePopoteTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {

                        var pasta by remember { mutableStateOf("") }
                        var acqua = 0;

                        try {
                            acqua = (parseInt(pasta) * 540) / 227;
                        }
                        catch (e: NumberFormatException) {
                            acqua = 0;
                        }

                        Row (modifier = Modifier.weight(2f), verticalAlignment = Alignment.CenterVertically) {
                            BigDisplayer(acqua)
                        }
                        Row (modifier = Modifier.weight(4f)) {
                            Surface(modifier = Modifier.fillMaxHeight(), color = dark200, shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)) {
                                Keyboard(pasta, onValueChange = { if (!pasta.isEmpty() || it != "0") { pasta += it } }, onReset = { pasta = it})
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

@Composable
fun Keyboard(value: String, onValueChange: (String) -> Unit, onReset: (String) -> Unit) {

    //var value by remember { mutableStateOf("") }

    Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row (modifier = Modifier.weight(1f).fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Column (modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
                .padding(end = 16.dp), horizontalAlignment = Alignment.End) {
                Row (verticalAlignment = Alignment.CenterVertically){
                    if (value.isEmpty()) {
                        Text("0", fontSize = 12.em, textAlign = TextAlign.End, overflow = TextOverflow.Ellipsis, maxLines = 1)
                    }
                    else {
                        Text(value, fontSize = 12.em, textAlign = TextAlign.End, overflow = TextOverflow.Ellipsis, maxLines = 1)
                    }
                    Text("g", modifier = Modifier.padding(start = 16.dp))
                }
            }
            Column(modifier = Modifier
                .weight(1f).fillMaxHeight()
                .clickable { onReset("") }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                KeyboardKey(value = "Del")
            }
        }
        Row (modifier = Modifier.weight(1f).fillMaxWidth()) {
            Column (modifier = Modifier
                .weight(1f).fillMaxHeight()
                .clickable { onValueChange("7") }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                KeyboardKey(value = "7")
            }
            Column (modifier = Modifier
                .weight(1f).fillMaxHeight()
                .clickable { onValueChange("8") }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                KeyboardKey(value = "8")
            }
            Column (modifier = Modifier
                .weight(1f).fillMaxHeight()
                .clickable { onValueChange("9") }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                KeyboardKey(value = "9")
            }
        }
        Row (modifier = Modifier.weight(1f)) {
            Column (modifier = Modifier
                .weight(1f).fillMaxHeight()
                .clickable { onValueChange("4") }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                KeyboardKey(value = "4")
            }
            Column (modifier = Modifier
                .weight(1f).fillMaxHeight()
                .clickable { onValueChange("5") }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                KeyboardKey(value = "5")
            }
            Column (modifier = Modifier
                .weight(1f).fillMaxHeight()
                .clickable { onValueChange("6") }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                KeyboardKey(value = "6")
            }
        }
        Row (modifier = Modifier.weight(1f)) {
            Column (modifier = Modifier
                .weight(1f).fillMaxHeight()
                .clickable { onValueChange("1") }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                KeyboardKey(value = "1")
            }
            Column (modifier = Modifier
                .weight(1f).fillMaxHeight()
                .clickable { onValueChange("2") }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                KeyboardKey(value = "2")
            }
            Column (modifier = Modifier
                .weight(1f).fillMaxHeight()
                .clickable { onValueChange("3") }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                KeyboardKey(value = "3")
            }
        }
        Row (modifier = Modifier.weight(1f)) {
            Column (modifier = Modifier
                .weight(1f).fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally) {
            }
            Column (modifier = Modifier
                .weight(1f).fillMaxHeight()
                .clickable { onValueChange("0") }, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                KeyboardKey(value = "0")
            }
            Column (modifier = Modifier
                .weight(1f).fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally) {
            }
        }
    }
}

@Composable
fun KeyboardKey(value: String) {
    Text(value, color = White, fontSize = 10.em)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OnePopoteTheme {
        KeyboardKey("1")
    }
}