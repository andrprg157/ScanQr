package com.scan.scanqr

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import scanqr.composeapp.generated.resources.Res
import scanqr.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {

        var currentScreen by remember { mutableStateOf("home") }
        var scanResult by remember { mutableStateOf("") }


        when(currentScreen)
        {
            "home" -> HomeScreen (onNavigate = { currentScreen = "scan"} )
            "scan" -> ScanScreen (

                onScanCompleted = {
                    result ->
                    scanResult = result
                    currentScreen = "result"
                }
            )
            "result" -> ResultScreen(resultText =scanResult){
                currentScreen = "home"
            }
        }
    }
}