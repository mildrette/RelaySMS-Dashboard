package com.example.relaysms_dashboard

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun RelayDashboardScreen() {
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxWidth().padding(30.dp).background(Color.White)) {
        Text("RelaySMS Dashboard", fontSize = 24.sp, modifier = Modifier.padding(8.dp))

        Spacer(modifier = Modifier.height(16.dp))


        val stats = listOf("Messages Sent" to 120, "Pending" to 5, "Synced" to 115)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            stats.forEach { stat ->
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color(0xFFBBDEFB))
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(stat.first)
                        Text(stat.second.toString(), fontSize = 20.sp)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            Toast.makeText(context, "Syncing messages...", Toast.LENGTH_SHORT).show()
        }) {
            Text("Sync Messages")
        }
    }
}


@Preview
@Composable
fun RelayDashboardScreenPreview() {
    RelayDashboardScreen()
}