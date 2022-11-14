package com.example.realmtargetsapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.realmtargetsapp.ui.theme.RealmTargetsAppTheme

class AddTargetActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RealmTargetsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    StatelessAddTarget()
                }
            }
        }
    }
}

@Composable
fun StatefulAddTarget(inputName: String,onClick :()-> Unit,onNameChange :(String)-> Unit,modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value =inputName ,
            onValueChange = onNameChange ,
            modifier = Modifier.padding(8.dp),
            label = {
                Text(text = "Hedefinizi Giriniz")
            }
        )
        Button(
            onClick = onClick
        ) {
            Text(text = "Save")
        }
    }
}

@Composable
fun StatelessAddTarget(modifier: Modifier = Modifier) {
    val database = RealmData()
    val context = LocalContext.current
    var inputName by remember{ mutableStateOf("") }
    StatefulAddTarget(
        inputName = inputName,
        onNameChange = { value -> inputName = value },
        onClick = {
            database.AddOnClick(nameTarget = inputName) }
    )
}