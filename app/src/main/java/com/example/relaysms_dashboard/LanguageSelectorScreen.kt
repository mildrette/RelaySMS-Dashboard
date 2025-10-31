package com.example.relaysms_dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LanguageSelectorScreen() {
    var selectedLanguage by remember { mutableStateOf("English") }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    modifier = Modifier.fillMaxSize().background(Color.White).padding(30.dp)) {
        Text("Language Selector", fontSize = 24.sp, modifier = Modifier.padding(8.dp))

        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(onClick = { selectedLanguage = "English" }) { Text("English") }
            Button(onClick = { selectedLanguage = "French" }) { Text("French") }
            Button(onClick = { selectedLanguage = "Farsi" }) { Text("Farsi") }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            when(selectedLanguage) {
                "English" -> "Welcome to Afkanerd Projects!"
                "French" -> "Bienvenue dans les projets Afkanerd!"
                "Farsi" -> "به پروژه‌های Afkanerd خوش آمدید!"
                else -> "Welcome!"
            },
            fontSize = 20.sp
        )
    }
}


@Preview
@Composable
fun LanguageSelectorScreenPreview() {
    LanguageSelectorScreen()
}