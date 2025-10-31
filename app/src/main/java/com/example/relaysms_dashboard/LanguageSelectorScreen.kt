package com.example.relaysms_dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LanguageSelectorScreen() {
    var selectedLanguage by remember { mutableStateOf("English") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F9FA))
            .padding(24.dp)
    ) {
        Text(
            text = "Language Selector",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF333333),
            modifier = Modifier.padding(bottom = 20.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 12.dp)
        ) {
            LanguageButton("English", selectedLanguage) { selectedLanguage = "English" }
            LanguageButton("French", selectedLanguage) { selectedLanguage = "French" }
            LanguageButton("Farsi", selectedLanguage) { selectedLanguage = "Farsi" }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = when (selectedLanguage) {
                "English" -> "Welcome to Afkanerd Projects!"
                "French" -> "Bienvenue dans les projets Afkanerd!"
                "Farsi" -> "به پروژه‌های Afkanerd خوش آمدید!"
                else -> "Welcome!"
            },
            fontSize = 20.sp,
            color = Color(0xFF555555)
        )
    }
}

@Composable
fun LanguageButton(language: String, selectedLanguage: String, onClick: () -> Unit) {
    val isSelected = language == selectedLanguage
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Color(0xFF4CAF50) else Color(0xFFE0E0E0),
            contentColor = if (isSelected) Color.White else Color.Black
        ),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .height(48.dp)
            .width(100.dp)
    ) {
        Text(language, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun LanguageSelectorScreenPreview() {
    LanguageSelectorScreen()
}
