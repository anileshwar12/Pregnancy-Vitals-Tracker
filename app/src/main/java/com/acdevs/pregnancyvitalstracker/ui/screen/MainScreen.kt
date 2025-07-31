import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.acdevs.pregnancyvitalstracker.ui.component.AddVitalsDialog
import com.acdevs.pregnancyvitalstracker.ui.component.VitalsCard
import com.acdevs.pregnancyvitalstracker.ui.theme.Purple40
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
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(padding) // Important: apply Scaffold's padding
        ) {
            items(vitalsList) { entry ->
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
