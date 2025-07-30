package com.acdevs.pregnancyvitalstracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.acdevs.pregnancyvitalstracker.ui.screen.MainScreen
import com.acdevs.pregnancyvitalstracker.ui.theme.PregnancyVitalsTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            PregnancyVitalsTrackerTheme {
                MainScreen()
            }
        }
    }
}
