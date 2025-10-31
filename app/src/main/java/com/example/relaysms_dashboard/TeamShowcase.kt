package com.example.relaysms_dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TeamShowcaseScreen() {
    val teamMembers = listOf(
        TeamMember("Mildred", "Frontend & Android", "Learning Android app development, translating apps", R.drawable.mildred),
        TeamMember("Promise", "Backend Developer", "Maintains API and database", R.drawable.promise),
        TeamMember("Vanessa", "UI/UX Designer", "Designs clean and responsive interfaces", R.drawable.vanessa),
        TeamMember("Aysha", "QA Tester", "Ensures apps are bug-free", R.drawable.aysha),
        TeamMember("Wisdom", "CEO & Android", "Building both Android and iOS apps and managing Afkanerd", R.drawable.wisdom),
        TeamMember("Favour", "Accountant and logistics person", "Manages finances, budgets, and coordinates logistics for projects", R.drawable.favour),
        TeamMember("Minet", "Logistic and secretary", "Supports team organization, schedules, and administrative tasks", R.drawable.minet)
    )

    val colors = listOf(
        Color(0xFFBBDEFB),
        Color(0xFFC8E6C9),
        Color(0xFFFFF9C4),
        Color(0xFFFFCCBC),
        Color(0xFFD1C4E9),
        Color(0xFFFFE0B2),
        Color(0xFFB2DFDB)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White)
    ) {
        Text(
            text = "Afkanerd Team Showcase",
            fontSize = 24.sp,
            modifier = Modifier.padding(8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(teamMembers.indices.toList()) { index ->
                val member = teamMembers[index]
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colors[index % colors.size], RoundedCornerShape(12.dp))
                        .padding(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = member.imageRes),
                            contentDescription = member.name,
                            modifier = Modifier
                                .size(64.dp)
                                .padding(end = 16.dp),
                            contentScale = ContentScale.Crop
                        )

                        Column {
                            Text(member.name, fontSize = 20.sp, color = Color.Black)
                            Text(member.role, fontSize = 16.sp)
                            Text(member.description, fontSize = 14.sp)
                        }
                    }
                }
            }
        }
    }
}

data class TeamMember(
    val name: String,
    val role: String,
    val description: String,
    val imageRes: Int
)

@Preview
@Composable
fun TeamShowcaseScreenPreview() {
    TeamShowcaseScreen()
}
