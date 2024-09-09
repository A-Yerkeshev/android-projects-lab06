package com.example.lab06

import Classworks.cw06_09.ParliamentMember
import android.app.Activity
import android.content.Intent
import android.content.Intent.getIntent
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.lab06.ui.theme.Lab06Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab06Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(40.dp)) {
                        PMemberCard(
                            Controller.getParliamentMember()!!,
                            modifier = Modifier.padding(innerPadding)
                        )
                        Button(onClick = {
                            finish();
                            startActivity(getIntent())
                        }) {
                            Text("Next")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PMemberCard(PM: ParliamentMember,
                modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "${PM.firstname} ${PM.lastname}",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Image(
            painter = RandomPlaceholder(),
            contentDescription = "${PM.firstname} ${PM.lastname}",
            modifier = Modifier
                .height(500.dp)
                .fillMaxWidth()
                .padding(16.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "party: ${PM.party}",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "seat number: ${PM.seatNumber}",
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PMemberCardPreview() {
    Lab06Theme {
        PMemberCard(Controller.getParliamentMember()!!)
    }
}

@Composable
fun RandomPlaceholder(): Painter {
    val placeholders: List<Int> = listOf(
        R.drawable.pm_image_placeholder_1,
        R.drawable.pm_image_placeholder_2,
        R.drawable.pm_image_placeholder_3)

    return painterResource(placeholders.random())
}