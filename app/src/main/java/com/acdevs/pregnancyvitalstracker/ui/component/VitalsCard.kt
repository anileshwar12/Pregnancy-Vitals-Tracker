package com.acdevs.pregnancyvitalstracker.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.acdevs.pregnancyvitalstracker.R
import com.acdevs.pregnancyvitalstracker.data.local.Vitals
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun VitalsCard(vitals: Vitals) {
    val date = SimpleDateFormat("EEE, dd MMM yyyy hh:mm a", Locale.getDefault()).format(Date(vitals.timestamp))

    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Column {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE1BEE7))
                    .padding(16.dp)
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    VitalsItem(painterResource(R.drawable.heartrate), "${vitals.heartRate} bpm")
                    VitalsItem(painterResource(R.drawable.bloodpressure), "${vitals.systolicBP}/${vitals.diastolicBP} mmHg")
                }
                Spacer(Modifier.height(12.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    VitalsItem(painterResource(R.drawable.scale), "${vitals.weight} kg")
                    VitalsItem(painterResource(R.drawable.newborn), "${vitals.kicks} kicks")
                }
            }


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF8E24AA))
                    .padding(vertical = 8.dp),
            ) {
                Text(
                    text = date,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(end = 16.dp)
                )
            }
        }
    }
}

@Composable
private fun VitalsItem(icon: Painter, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text, color = Color.Black, style = MaterialTheme.typography.bodyMedium)
    }
}


