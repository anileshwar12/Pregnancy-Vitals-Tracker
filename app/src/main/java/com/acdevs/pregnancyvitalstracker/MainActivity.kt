package com.acdevs.pregnancyvitalstracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.acdevs.pregnancyvitalstracker.ui.screen.MainScreen
import com.acdevs.pregnancyvitalstracker.ui.theme.PregnancyVitalsTrackerTheme
import com.acdevs.pregnancyvitalstracker.util.RequestNotificationPermission

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            PregnancyVitalsTrackerTheme {
                RequestNotificationPermission()
                MainScreen()
            }
        }
    }
}
