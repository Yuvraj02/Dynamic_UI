package com.example.dynamicui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dynamicui.ui.theme.DynamicUITheme

val list: ArrayList<String> = arrayListOf("John","Michael","Dana","Andrew")

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
fun MainScreen(){
    Column(modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.SpaceEvenly,horizontalAlignment = Alignment.CenterHorizontally) {
        GreetingList()
    }
}

@Composable
fun GreetingList(){

    val greetingListState = remember {mutableStateListOf<String>("Yuvraj","Nishchay")}

    for (name in greetingListState){
        Text(text = "Hello $name",style = MaterialTheme.typography.h3)
    }
    
    Button(onClick = { greetingListState.add("Rashi")}) {
        Text(text = "Add new name")
        
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