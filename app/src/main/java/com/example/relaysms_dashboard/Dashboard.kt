package com.example.relaysms_dashboard

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun RelayDashboardScreen() {
    val context = LocalContext.current

    var messageInput by remember { mutableStateOf("") }
    var messages by remember { mutableStateOf(
        mutableListOf(
            MessageItem("Hello!", MessageStatus.SENT),
            MessageItem("Pending message...", MessageStatus.PENDING),
            MessageItem("Update synced", MessageStatus.SYNCED)
        )
    )}

    val totalSent = messages.count { it.status == MessageStatus.SENT || it.status == MessageStatus.SYNCED }
    val totalPending = messages.count { it.status == MessageStatus.PENDING }
    val totalSynced = messages.count { it.status == MessageStatus.SYNCED }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F9FC))
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Hello Mildred!", fontSize = 20.sp, color = Color(0xFF333333), modifier = Modifier.align(Alignment.Start))
        Text("Here's your dashboard today", fontSize = 14.sp, color = Color.Gray, modifier = Modifier.align(Alignment.Start).padding(bottom = 16.dp))


        val stats = listOf(
            Triple("Messages Sent", totalSent.toString(), Color(0xFF81C784)),
            Triple("Pending", totalPending.toString(), Color(0xFFFFB74D)),
            Triple("Synced", totalSynced.toString(), Color(0xFF64B5F6))
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            stats.forEach { (label, value, color) ->
                Card(modifier = Modifier.weight(1f).padding(horizontal = 4.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(label, fontSize = 14.sp, color = Color.Gray)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(value, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = color)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = messageInput,
            onValueChange = { messageInput = it },
            label = { Text("Type a message") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        val coroutineScope = rememberCoroutineScope()

        Button(
            onClick = {
                if (messageInput.isNotBlank()) {
                    messages.add(MessageItem(messageInput, MessageStatus.PENDING))
                    messageInput = ""

                    coroutineScope.launch {
                        kotlinx.coroutines.delay(2000)
                        messages[messages.lastIndex] = messages.last().copy(status = MessageStatus.SENT)
                    }
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Send")
        }


        Spacer(modifier = Modifier.height(24.dp))

        Text("Recent Activity", fontWeight = FontWeight.Medium, fontSize = 16.sp, modifier = Modifier.align(Alignment.Start))
        messages.reversed().forEach { msg ->
            Card(
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = when(msg.status) {
                    MessageStatus.PENDING -> Color(0xFFFFF9C4)
                    MessageStatus.SENT -> Color(0xFFC8E6C9)
                    MessageStatus.SYNCED -> Color(0xFFBBDEFB)
                }),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Row(modifier = Modifier.padding(12.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(msg.content, color = Color(0xFF333333))
                    Text(msg.status.name, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

data class MessageItem(val content: String, val status: MessageStatus)
enum class MessageStatus { PENDING, SENT, SYNCED }


@Composable
fun QuickActionButton(label: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE0E0E0)),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.height(44.dp)
    ) {
        Text(label, fontSize = 14.sp, color = Color(0xFF333333))
    }
}

@Preview(showBackground = true)
@Composable
fun RelayDashboardScreenPreview() {
    RelayDashboardScreen()
}
