package com.example.relaysms_dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.People



@Composable
fun AfkanerdApp() {
    var selectedScreen by remember { mutableStateOf("dashboard") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F9FA))
            .padding(16.dp)
    ) {
        Text(
            text = "Afkanerd Projects",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF212121),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp, bottom = 24.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .background(Color.White, shape = MaterialTheme.shapes.medium)
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavButton(
                icon = Icons.Default.Dashboard,
                label = "Dashboard",
                selected = selectedScreen == "dashboard"
            ) { selectedScreen = "dashboard" }

            NavButton(
                icon = Icons.Default.Language,
                label = "Language",
                selected = selectedScreen == "language"
            ) { selectedScreen = "language" }

            NavButton(
                icon = Icons.Default.People,
                label = "Team",
                selected = selectedScreen == "team"
            ) { selectedScreen = "team" }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            shape = MaterialTheme.shapes.large,
            shadowElevation = 4.dp
        ) {
            when (selectedScreen) {
                "dashboard" -> RelayDashboardScreen()
                "language" -> LanguageSelectorScreen()
                "team" -> TeamShowcaseScreen()
            }
        }
    }
}

@Composable
fun NavButton(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String, selected: Boolean, onClick: () -> Unit) {
    val backgroundColor = if (selected) Color(0xFF4CAF50) else Color.Transparent
    val contentColor = if (selected) Color.White else Color(0xFF4CAF50)

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .height(48.dp)
            .padding(horizontal = 4.dp)
    ) {
        Icon(imageVector = icon, contentDescription = label, modifier = Modifier.size(20.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text(label, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun AfkanerdAppPreview() {
    AfkanerdApp()
}
