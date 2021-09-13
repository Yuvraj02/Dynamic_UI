package com.example.dynamicui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dynamicui.ui.theme.DynamicUITheme

val list: ArrayList<String> = arrayListOf("John", "Michael", "Dana", "Andrew")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DynamicUITheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    // Greeting("Android")
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel:MainViewModel = MainViewModel()) {

   // val greetingListState = remember { mutableStateListOf<String>("Yuvraj", "Nishchay") }
    val newNameSetContent = viewModel.textFieldState.observeAsState("")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GreetingMessage(
            newNameSetContent.value
        ) { newName -> viewModel.onTextChanged(newName) }
    }
}

@Composable
fun GreetingMessage(
    textFieldValue: String,
    textFieldUpdate: (newName: String) -> Unit
) {

//    for (name in namesList) {
//        Text(text = "Hello $name", style = MaterialTheme.typography.h3)
//    }


    TextField(
        value = textFieldValue,
        onValueChange = textFieldUpdate
    )

    Button(onClick = {}) {
        Text(text = textFieldValue)

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DynamicUITheme {
        //Greeting("Android")
        MainScreen()
    }
}