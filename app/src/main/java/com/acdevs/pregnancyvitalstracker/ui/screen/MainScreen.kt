package com.acdevs.pregnancyvitalstracker.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.acdevs.pregnancyvitalstracker.ui.component.AddVitalsDialog
import com.acdevs.pregnancyvitalstracker.ui.component.VitalsCard
import com.acdevs.pregnancyvitalstracker.ui.theme.Pink40
import com.acdevs.pregnancyvitalstracker.ui.theme.Purple40
import com.acdevs.pregnancyvitalstracker.ui.theme.Purple80
import com.acdevs.pregnancyvitalstracker.viewmodel.VitalsViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(vm: VitalsViewModel = koinViewModel()) {
    val vitalsList by vm.vitals.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Pregnancy Vitals Tracker",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Start
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFBB86FC)
                )
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true },
                shape = CircleShape,
                containerColor = Purple40
            ) {
                Text("+", color = Color.White)
            }
        }

    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            vitalsList.forEach { entry ->
                VitalsCard(entry)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }

    if (showDialog) {
        AddVitalsDialog(
            onDismiss = { showDialog = false },
            onSubmit = {
                vm.logVitals(it)
                showDialog = false
            }
        )
    }
}

