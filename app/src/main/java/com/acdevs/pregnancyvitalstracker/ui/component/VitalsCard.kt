package com.acdevs.pregnancyvitalstracker.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FitnessCenter
import androidx.compose.material.icons.outlined.MonitorHeart
import androidx.compose.material.icons.outlined.PregnantWoman
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    VitalsItem(Icons.Outlined.Favorite, "${vitals.heartRate} bpm")
                    VitalsItem(Icons.Outlined.MonitorHeart, "${vitals.systolicBP}/${vitals.diastolicBP} mmHg")
                }
                Spacer(Modifier.height(12.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    VitalsItem(Icons.Outlined.FitnessCenter, "${vitals.weight} kg")
                    VitalsItem(Icons.Outlined.PregnantWoman, "${vitals.kicks} kicks")
                }
            }


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF8E24AA))
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = date,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
private fun VitalsItem(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text, color = Color.Black, style = MaterialTheme.typography.bodyMedium)
    }
}

//@Preview(showBackground = true)
//@Composable
//fun VitalsCardPreview() {
//    VitalsCard(
//        vitals = Vitals(
//            id = 0,
//            systolicBP = 129,
//            diastolicBP = 86,
//            heartRate = 87,
//            weight = 75f,
//            kicks = 9,
//            timestamp = 1731364920000L // Sun, 12 Jan 2025 10:22 am
//        )
//    )
//}
