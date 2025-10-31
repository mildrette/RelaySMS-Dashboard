package com.example.relaysms_dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AfkanerdApp() {
    var selectedScreen by remember { mutableStateOf("dashboard") }

    Column(modifier = Modifier.fillMaxSize().padding(30.dp).background(Color.White)) {

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = { selectedScreen = "dashboard" }) { Text("Dashboard") }
            Button(onClick = { selectedScreen = "language" }) { Text("Language") }
            Button(onClick = { selectedScreen = "team" }) { Text("Team") }
        }

        Spacer(modifier = Modifier.height(16.dp))


        when (selectedScreen) {
            "dashboard" -> RelayDashboardScreen()
            "language" -> LanguageSelectorScreen()
            "team" -> TeamShowcaseScreen()
        }
    }
}

@Preview
@Composable
fun AfkanerdAppPreview() {
    AfkanerdApp()
}