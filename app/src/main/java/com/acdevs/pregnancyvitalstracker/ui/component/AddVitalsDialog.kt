package com.acdevs.pregnancyvitalstracker.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.acdevs.pregnancyvitalstracker.data.local.Vitals
import com.acdevs.pregnancyvitalstracker.ui.theme.Purple40

@Composable
fun AddVitalsDialog(
    onDismiss: () -> Unit,
    onSubmit: (Vitals) -> Unit
) {
    var systolic by remember { mutableStateOf("") }
    var diastolic by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var heartrate by remember { mutableStateOf("") }
    var kicks by remember { mutableStateOf("") }

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Add Vitals",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedTextField(
                        value = systolic,
                        onValueChange = { systolic = it },
                        label = { Text("Sys BP") },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(8.dp),

                    )

                    OutlinedTextField(
                        value = diastolic,
                        onValueChange = { diastolic = it },
                        label = { Text("Dia BP") },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(8.dp),

                    )
                }

                OutlinedTextField(
                    value = weight,
                    onValueChange = { weight = it },
                    label = { Text("Weight ( in kg )") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),

                    )
                OutlinedTextField(
                    value = heartrate,
                    onValueChange = { heartrate = it },
                    label = { Text("Heart Rate") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),

                    )
                OutlinedTextField(
                    value = kicks,
                    onValueChange = { kicks = it },
                    label = { Text("Baby Kicks") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),

                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                        onSubmit(
                            Vitals(
                                systolicBP = systolic.toIntOrNull() ?: 0,
                                diastolicBP = diastolic.toIntOrNull() ?: 0,
                                heartRate = heartrate.toIntOrNull() ?: 0,
                                weight = weight.toFloatOrNull() ?: 0f,
                                kicks = kicks.toIntOrNull() ?: 0
                            )
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Purple40
                    )

                ) {
                    Text(
                        text = "Submit",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}
