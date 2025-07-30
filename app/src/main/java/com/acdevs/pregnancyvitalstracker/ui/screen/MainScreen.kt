package com.acdevs.pregnancyvitalstracker.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.acdevs.pregnancyvitalstracker.ui.component.AddVitalsDialog
import com.acdevs.pregnancyvitalstracker.ui.component.VitalsCard
import com.acdevs.pregnancyvitalstracker.viewmodel.VitalsViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun MainScreen(vm: VitalsViewModel = koinViewModel()) {
    val vitalsList by vm.vitals.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true }) {
                Text("+")
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            vitalsList.forEach { entry ->
                VitalsCard(entry)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }

    if (showDialog) {
        AddVitalsDialog(
            onDismiss = { showDialog = false },
            onSubmit = { vm.logVitals(it); showDialog = false }
        )
    }
}



//@Composable
//@Preview
//fun MainScreenPreview() {
//    MainScreen()
//}